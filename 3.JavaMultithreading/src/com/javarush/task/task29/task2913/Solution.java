package com.javarush.task.task29.task2913;

import java.util.Random;

/* 
Замена рекурсии
*/

public class Solution {
    private static int numberA;
    private static int numberB;

    /*public static String recursion(int a, int b) {
        if (a > b) {
            return a + " " + recursion(a - 1, b);
        } else {
            if (a == b) {
                return Integer.toString(a);
            }
            return a + " " + recursion(a + 1, b);
        }
    }*/
    /*public static String getAllNumbersBetween(int a, int b) {
        StringBuilder sb = new StringBuilder();
        if (a > b) {
            sb.append(b);
            for (int i = b+1; i <=a ; i++) {
                sb.append(" ").append(i);
            }
        } else if (a < b){
            sb.append(a);
            for (int i = a+1; i <=b ; i++) {
                sb.append(" ").append(i);
            }
        } else sb.append(a);

        return sb.toString();
    }*/
    public static String getAllNumbersBetween(int a, int b) {
        String aBetwenB = a+"";
        if (a > b) {
            for (int i = a-1; i >= b; i--) {
                aBetwenB = aBetwenB + " " + i;
            }
        }
        else if (a < b) {
            for (int i = a+1; b >= i; i++) {
                aBetwenB = aBetwenB + " " + i;
            }
        }
        else aBetwenB = String.valueOf(a);
        return aBetwenB;
    }

    public static void main(String[] args) {
        Random random = new Random();
        numberA = random.nextInt() % 1_000;
        numberB = random.nextInt() % 10_000;
        System.out.println(getAllNumbersBetween(numberA, numberB));
        System.out.println(getAllNumbersBetween(numberB, numberA));
    }
}