package com.javarush.task.task04.task0428;

/* 
Положительное число
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n1 = Integer.parseInt(bufferedReader.readLine());
        int n2 = Integer.parseInt(bufferedReader.readLine());
        int n3 = Integer.parseInt(bufferedReader.readLine());
        int count = 0;

        if (n1 > 0) count++;
        if (n2 > 0) count++;
        if (n3 > 0) count++;

        System.out.println(count);

    }
}
