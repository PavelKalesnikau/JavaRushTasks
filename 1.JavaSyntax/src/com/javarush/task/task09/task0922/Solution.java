package com.javarush.task.task09.task0922;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* 
Какое сегодня число?
*/

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // Get date as string
        String dateS = reader.readLine();

        // Create date formatter with localisation
        SimpleDateFormat dateFormat = (SimpleDateFormat) DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.US);

        Date date = new Date(dateS);
        // print date in given format converted to upper case
        System.out.println(dateFormat.format(date).toUpperCase());

    }
}
