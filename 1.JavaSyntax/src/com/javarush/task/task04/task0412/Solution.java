package com.javarush.task.task04.task0412;

/* 
Положительное и отрицательное число
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        int n = Integer.parseInt(s);
        if (n > 0) n = n * 2;
        else if (n < 0) n = n + 1;
        System.out.println(n);
    }

}