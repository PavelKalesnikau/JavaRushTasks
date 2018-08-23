package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int count = 0, sum = 0;
        while (true){
            int n = Integer.parseInt(bufferedReader.readLine());
            if (n == -1) break;
            sum +=n;
            count ++;
        }
        System.out.println((double)sum/count);
    }
}

