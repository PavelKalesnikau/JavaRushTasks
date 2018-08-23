package com.javarush.task.task04.task0442;


/* 
Суммирование
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = 0, sum = 0;
        while (true){
            n = Integer.parseInt(bufferedReader.readLine());
            sum += n;
            if (n == -1) break;
        }
        System.out.println(sum);
    }
}
