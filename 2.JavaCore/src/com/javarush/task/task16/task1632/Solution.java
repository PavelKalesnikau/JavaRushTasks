package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);
    static {
        threads.add(new Thread1());
        threads.add(new Thread2());
        threads.add(new Thread3());
        threads.add(new Thread4());
        threads.add(new Thread5());
    }
    public static void main(String[] args) {
        for (Thread t : threads ) {
            t.start();
        }
    }

    public static class Thread1 extends Thread {
        @Override
        public void run() {
            while (true) {

            }
        }
    }

    public static class Thread2 extends Thread {
        @Override
        public void run() {
            try {
                while (true) {
                    Thread.sleep(10);
                }
            } catch (InterruptedException e) {
//                e.printStackTrace();
                System.out.println("InterruptedException");
            }
        }
    }

    public static class Thread3 extends Thread {
        @Override
        public void run() {
            try {
                while (true) {
                    System.out.println("Ура");
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
            }
        }
    }

    public static class Thread4 extends Thread implements Message {
        @Override
        public void run() {
            while (!isInterrupted()) {

            }
        }

        @Override
        public void showWarning() {
            interrupt();
        }
    }
    public static class Thread5 extends Thread {
        @Override
        public void run() {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String line;
            int sum = 0;
            try {
                while (!(line = reader.readLine()).equals("N")) {
                    int n = Integer.parseInt(line);
                    sum += n;
                }
                System.out.println(sum);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}