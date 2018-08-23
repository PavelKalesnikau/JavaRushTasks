package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] houses = new int[15];
        int oddCounts = 0;
        int evenCounts = 0;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < houses.length; i++) {
            houses[i] = Integer.parseInt(reader.readLine());
        }

        //В домах с нечетными номерами проживает больше жителей
        //В домах с четными номерами проживает больше жителей
        for (int i = 0; i < houses.length; i++) {
            if (i%2 == 0)  evenCounts+=houses[i];
            else oddCounts += houses[i];
        }
        if (evenCounts > oddCounts) System.out.println("В домах с четными номерами проживает больше жителей.");
        else System.out.println("В домах с нечетными номерами проживает больше жителей.");
    }
}
