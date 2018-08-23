package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
        System.out.println(getPartOfString("JavaRush - лучший сервис."));
    }

    public static String getPartOfString(String string) {
        try {
            String[] str  = string.split(" ");
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i < 5; i++) {
                if (i != 1 && i != 5) sb.append(" ");
               sb.append(str[i]);
            }

            return sb.toString();

        } catch (Exception e) {
            throw new TooShortStringException();
        }
    }
    public static class TooShortStringException extends RuntimeException {
    }
}
