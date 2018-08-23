package com.javarush.task.task03.task0305;

/* 
Я так давно родился
*/

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Solution {
    public static void main(String[] args) {

        LocalDate dateOfBirth = LocalDate.of(1983, Month.OCTOBER, 22);
        System.out.printf("%S%n", dateOfBirth.format(DateTimeFormatter.ofPattern("MMMM d YYYY", Locale.ENGLISH)));
    }
}
