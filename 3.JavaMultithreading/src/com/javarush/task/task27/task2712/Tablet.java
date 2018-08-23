package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.AdvertisementManager;
import com.javarush.task.task27.task2712.ad.NoVideoAvailableException;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.TestOrder;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.io.IOException;
import java.util.Observable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tablet {
    static Logger logger = Logger.getLogger(Tablet.class.getName());
    final int number;
    private LinkedBlockingQueue<Order> queue = new LinkedBlockingQueue<Order>();

    public void setQueue(LinkedBlockingQueue<Order> orderQueue) {
        this.queue = orderQueue;
    }

    public Tablet(int number) {
        this.number = number;
    }

    public Order createOrder() {
        try {
            Order order = new Order(this);
            registerAdvertisement(order);
            return order;
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
            return null;
        }
    }

    public void createTestOrder() {
        try {
            final Order order = new TestOrder(this);
            registerAdvertisement(order);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
        }
    }

    private void registerAdvertisement(Order order) {
        try {
            AdvertisementManager advertisementManager = new AdvertisementManager(order.getTotalCookingTime() * 60);
            advertisementManager.processVideos();
            if (!order.isEmpty()) {
//                setChanged();
//                notifyObservers(order);
                queue.add(order);

                StatisticManager.getInstance().register(new VideoSelectedEventDataRow(advertisementManager.getSelectedVideos(),
                        advertisementManager.getAmountSelectedVideos(), advertisementManager.getSelectedTotalTime()));
            }
        } catch (NoVideoAvailableException e) {
            logger.log(Level.INFO, "No video is available for the order " + order);
        }
    }

    @Override
    public String toString() {
        return "Tablet{" +
                "number=" + number +
                '}';
    }

}
