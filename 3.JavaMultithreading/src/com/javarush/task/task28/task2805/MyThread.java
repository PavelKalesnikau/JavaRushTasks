package com.javarush.task.task28.task2805;

public class MyThread extends Thread {
    private static int priority = 1;

    public MyThread() {
        setCustomPriority();
    }

    public MyThread(Runnable target) {
        super(target);
        setCustomPriority();
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        setCustomPriority();
    }

    public MyThread(String name) {
        super(name);
        setCustomPriority();
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        setCustomPriority();
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        setCustomPriority();
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        setCustomPriority();
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        setCustomPriority();
    }

    private synchronized void setCustomPriority() {
        int threadGroupPriority = Thread.currentThread().getThreadGroup().getMaxPriority();

        if (priority > 10) priority = 1;
        if (priority >= threadGroupPriority) {
            setPriority(threadGroupPriority);
        } else {
            setPriority(priority);
        }
        priority++;
    }
}
