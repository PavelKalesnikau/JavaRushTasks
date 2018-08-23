package com.javarush.task.task07.task0705;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Один большой массив и два маленьких
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] numbers1 = new int[20];
        int[] numbers2 = new int[10];
        int[] numbers3 = new int[10];

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 20; i++) {
            numbers1[i] = Integer.parseInt(reader.readLine());
        }
        for (int i = 0; i < 20; i++) {
            if (i < 10) numbers2[i] = numbers1[i];
            else {
                numbers3[i-10] = numbers1[i];
                System.out.println(numbers3[i-10]);
            }
        }

    }
}

