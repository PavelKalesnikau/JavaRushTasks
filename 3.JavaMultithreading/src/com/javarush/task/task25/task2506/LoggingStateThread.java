package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread {
    Thread thread;

    public LoggingStateThread(Thread thread) {
        this.thread = thread;
        System.out.println(thread.getState());
    }

    @Override
    public void run() {
        State st = thread.getState();
        System.out.println(st);
        while(st != State.TERMINATED){
            if(st != thread.getState()) {
                st = thread.getState();
                System.out.println(st);
            }
        }
        /*  boolean runnable = false;
        Thread.State state;

        while (true) {
            state = thread.getState();

            if (state == State.TERMINATED) break;

            if (!runnable)
                System.out.println(state);

            runnable = true;
        }
        state = thread.getState();
        System.out.println(state);*/
    }
}
