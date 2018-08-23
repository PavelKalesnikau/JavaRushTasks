package com.javarush.task.task04.task0415;

/* 
Правило треугольника
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s1 = bufferedReader.readLine();
        int a = Integer.parseInt(s1);
        String s2 = bufferedReader.readLine();
        int b = Integer.parseInt(s2);
        String s3 = bufferedReader.readLine();
        int c = Integer.parseInt(s3);

        if ( a > b+c || b > a+c || c > a+b ) System.out.println("Треугольник не существует.");
        else System.out.println("Треугольник существует.");
//        boolean exists = (a + b > c) && (a + c > b) && (c + b > a);
//        if (exists) {
//            System.out.println("Треугольник существует.");
//        } else {
//            System.out.println("Треугольник не существует.");
//        }

    }
}