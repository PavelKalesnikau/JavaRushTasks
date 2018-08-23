package com.javarush.task.task27.task2712.kitchen;


import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;

import java.util.Observable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Cook extends Observable implements Runnable {
    private String name;
    private boolean busy;
    private LinkedBlockingQueue<Order> queue = new LinkedBlockingQueue<Order>();

    public Cook(String name) {
        this.name = name;
    }

    public void setQueue(LinkedBlockingQueue<Order> queue) {
        this.queue = queue;
    }

    public boolean isBusy() {
        return busy;
    }

    @Override
    public String toString() {
        return name;
    }

    public void startCookingOrder(Order order) {
        busy = true;
        ConsoleHelper.writeMessage("Start cooking - " + order + String.format(", cooking time %dmin", order.getTotalCookingTime()));
        setChanged();
        notifyObservers(order);

        StatisticManager.getInstance().register(
                new CookedOrderEventDataRow(order.getTablet().toString(), name, order.getTotalCookingTime(), order.getDishes())
        );
        try {
            Thread.sleep(order.getTotalCookingTime() * 10);
        } catch (InterruptedException e) {
        }
        busy = false;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
//                if (queue.isEmpty() && !isBusy()) { // есть заказы и повар свободен
//                     startCookingOrder(orderQueue.poll());
                     startCookingOrder(queue.take());
                Thread.sleep(10);
//                }
            } catch (InterruptedException e) {
//                break;
                return;
            }
        }
    }
}
