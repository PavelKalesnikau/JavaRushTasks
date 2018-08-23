package com.javarush.task.task08.task0827;

import java.util.Calendar;
import java.util.Date;

/* 
Работа с датой
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(isDateOdd("MAY 1 2013"));
//        System.out.println(isDateOdd("JANUARY 1 2000"));
//        System.out.println(isDateOdd("JANUARY 2 2020"));
    }

    public static boolean isDateOdd(String date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(date));
        int dayOfYear = calendar.get(Calendar.DAY_OF_YEAR);

        if (dayOfYear % 2 == 1) return true;
        else return false;
    }
}
