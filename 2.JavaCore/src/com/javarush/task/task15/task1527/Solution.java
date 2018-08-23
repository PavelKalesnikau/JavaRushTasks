package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Парсер реквестов
*/
// URL для тестирования
// http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
// http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
// javarush.ru/alpha/index.html?lvl=15&view&name=Aobjmigo&obj=3.14&name=&obj=djsdcd&oobj=3.0&obj=1&obj=2.3&obj=aaa
public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        try {
            String url = reader.readLine();
            String[] params =  url.split("\\?")[1].split("&");

            for (String s: params ) {
                System.out.print(s.split("=")[0] + " ");
            }
            System.out.println();

            for (String s: params ) {
                if (s.split("=")[0].equals("obj")){
                    String value = s.split("=")[1];

                    try {
                        double number = Double.valueOf(value);
                        alert(number);
                    } catch (NumberFormatException e) {
                        alert(value);
                    }

                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
