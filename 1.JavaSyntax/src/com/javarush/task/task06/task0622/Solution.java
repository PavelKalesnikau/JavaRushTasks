package com.javarush.task.task06.task0622;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Числа по возрастанию
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = new int[5];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(reader.readLine());
        }

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i; j < numbers.length; j++) {
                if (numbers[i] > numbers[j]){
                    int number = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = number;
                }
            }
        }

        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
    }
}

