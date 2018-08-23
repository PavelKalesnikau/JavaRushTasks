package com.javarush.task.task04.task0427;

/* 
Описываем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        if( n%2 == 0 && (n>0 && n <= 9)) System.out.println("четное однозначное число");
        else if( n%2 != 0 && (n>0 && n <=9)) System.out.println("нечетное однозначное число");
        else if( n%2 == 0 && (n>=10 && n <= 99)) System.out.println("четное двузначное число");
        else if( n%2 != 0 && (n>=10 && n <= 99)) System.out.println("нечетное двузначное число");
        else if( n%2 == 0 && (n>=100 && n <= 999)) System.out.println("четное трехзначное число");
        else if( n%2 != 0 && (n>=100 && n <= 999)) System.out.println("нечетное трехзначное число");


    }
}
