package com.javarush.task.task25.task2511;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimerTask;

/* 
Вооружаемся до зубов!
*/
public class Solution extends TimerTask {
    protected final Thread.UncaughtExceptionHandler handler;
    protected TimerTask original;

    public Solution(TimerTask original) {
        if (original == null) {
            throw new NullPointerException();
        }

        this.original = original;

        this.handler = new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                String message = e.getLocalizedMessage();
                String threadName = t.getName();
                int threadNameLength = threadName.length();
                StringBuilder replaceString = new StringBuilder();
                for (int i = 0; i < threadNameLength; i++) {
                    replaceString.append('*');
                }
                System.out.println(message.replace(threadName, replaceString));
            }
        };
    }

    public static void main(String[] args) {

        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
          /*      Calendar calendar = Calendar.getInstance();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
                        "dd:MMMM:yyyy HH:mm:ss a", Locale.getDefault());
                final String strDate = simpleDateFormat.format(calendar.getTime());
                System.out.println(strDate);*/
                throw new RuntimeException();
            }
        };

        Solution solution = new Solution(tt);
        solution.run();
    }

    public void run() {
        try {
            original.run();
        } catch (Throwable cause) {
            Thread currentThread = Thread.currentThread();
            handler.uncaughtException(currentThread, new Exception("Blah " + currentThread.getName() + " blah-blah-blah", cause));
        }
    }

    public long scheduledExecutionTime() {
        return original.scheduledExecutionTime();
    }

    public boolean cancel() {
        return original.cancel();
    }
}