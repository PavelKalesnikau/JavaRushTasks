package com.javarush.task.task07.task0703;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Общение одиноких массивов
*/

public class Solution {
    public static void main(String[] args) throws Exception {
     String[] strings = new String[10];
     int[] countRows = new int[10];

     BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            strings[i] = reader.readLine();
        }
        for (int i = 0; i < 10; i++) {
            countRows[i] = strings[i].length();
            System.out.println(countRows[i]);
        }
    }
}
