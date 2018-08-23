package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = null;

        while (true) {
            input = reader.readLine();
            if (input.equals("exit")) break;
            try {
                if (input.contains(".")) {
                    Double value = Double.valueOf(input);
                    print(value);
                }else if (Integer.valueOf(input) > 0 && Integer.valueOf(input) < 128){
                    print(Short.valueOf(input));
                }else if (Integer.valueOf(input) <= 0 || Integer.valueOf(input) >= 128){
                    print(Integer.valueOf(input));
                }else {
                    print(input);
                }
            } catch (NumberFormatException e) {
                print(input);
            }
        }
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
