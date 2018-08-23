package com.javarush.task.task08.task0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Номер месяца
*/

public class Solution {
    public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    HashMap<String, Integer> months = new HashMap<String, Integer>();
    months.put("January", 1);
    months.put("February", 2);
    months.put("March", 3);
    months.put("April", 4);
    months.put("May", 5);
    months.put("June", 6);
    months.put("July", 7);
    months.put("August", 8);
    months.put("September", 9);
    months.put("October", 10);
    months.put("November", 11);
    months.put("December", 12);

    String month = reader.readLine();

    //«May is 5 month».
    System.out.println(month+ " is "+ months.get(month) + " month");

    }
}
