package com.javarush.task.task05.task0528;

/* 
Вывести на экран сегодняшнюю дату
*/

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class Solution {
    public static void main(String[] args) {
//        Date date = new Date();
//        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG, Locale.getDefault());
//        System.out.println(dateFormat.format(date));

        LocalDate date = LocalDate.now();
        int day = date.getDayOfMonth();
        int month = date.getMonthValue();
        int year = date.getYear();
//        System.out.printf("%S%n", date.format(DateTimeFormatter.ofPattern("MMMM d YYYY", Locale.ENGLISH)));
        System.out.println(day + " " + month + " " + year);
    }
}
