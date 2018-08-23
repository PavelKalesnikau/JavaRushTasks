package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.Waiter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Restaurant {
    private static final int ORDER_CREATING_INTERVAL = 100;
    private static final LinkedBlockingQueue<Order> orderQueue = new LinkedBlockingQueue<Order>();

    public static void main(String[] args) {
        Cook cook = new Cook("Ivanov");
        cook.setQueue(orderQueue);

        Cook cook2 = new Cook("Petrov");
        cook2.setQueue(orderQueue);

        Thread cookThread = new Thread(cook);
        Thread cookThread2 = new Thread(cook2);
        cookThread.start();
        cookThread2.start();

        Waiter waiter = new Waiter();
        cook.addObserver(waiter);
        cook2.addObserver(waiter);

//        StatisticManager.getInstance().register(cook);
//        StatisticManager.getInstance().register(cook2);

//        Tablet tablet5 = new Tablet(5);
//        tablet5.addObserver(cook);
//        tablet5.addObserver(cook2);
//        tablet5.createOrder();

        List<Tablet> tablets = new ArrayList<Tablet>();
        for (int i = 0; i < 5; i++) {
            Tablet tablet = new Tablet(i);
//            tablet.addObserver(orderManager);
            tablet.setQueue(orderQueue);
            tablets.add(tablet);
        }
        Thread threadOrderGenerator = new Thread(new RandomOrderGeneratorTask(tablets, ORDER_CREATING_INTERVAL));
        threadOrderGenerator.start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadOrderGenerator.interrupt();
        cookThread.interrupt();
        cookThread2.interrupt();

        try {
            cookThread.join();
            cookThread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printCookWorkloading();
        directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();
    }
}
