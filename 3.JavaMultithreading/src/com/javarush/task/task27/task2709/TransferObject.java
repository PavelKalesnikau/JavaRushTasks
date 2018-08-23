package com.javarush.task.task27.task2709;

public class TransferObject {
    protected volatile boolean isValuePresent = false; //use this variable
    private int value;

    public synchronized int get() {
        while (!isValuePresent) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isValuePresent = false;
        this.notifyAll();

        System.out.println("Got: " + value);
        return value;
    }

    public synchronized void put(int value) {
        while (isValuePresent) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isValuePresent = true;
        this.notifyAll();

        this.value = value;
        System.out.println("Put: " + value);
    }
}
