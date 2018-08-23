package com.javarush.task.task25.task2512;

/* 
Живем своим умом
*/
public class Solution implements Thread.UncaughtExceptionHandler {

    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.setUncaughtExceptionHandler(new Solution());
        thread.start();
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();

        Throwable cause = e.getCause();
        if (cause != null){
            uncaughtException(t, cause);
        }
        System.out.println(e);
    }

    public static class MyThread extends Thread {
        @Override
        public void run() {
            try {
                throw new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI")));
            } catch (Exception e) {
                getUncaughtExceptionHandler().uncaughtException(this, e);
            }
        }
    }
}
