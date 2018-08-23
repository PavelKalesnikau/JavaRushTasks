package com.javarush.task.task27.task2712;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class RandomOrderGeneratorTask implements Runnable {
    private List<Tablet> tablets;
    private int interval;

    public RandomOrderGeneratorTask(List<Tablet> tablets, int interval) {
        this.tablets = tablets;
        this.interval = interval;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                TimeUnit.MILLISECONDS.sleep(interval);
                Tablet tablet = tablets.get((int) (Math.random() * tablets.size()));
                tablet.createTestOrder();
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
