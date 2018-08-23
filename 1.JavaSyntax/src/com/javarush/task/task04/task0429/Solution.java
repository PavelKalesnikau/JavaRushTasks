package com.javarush.task.task04.task0429;

/* 
Положительные и отрицательные числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
//        "количество отрицательных чисел: 0".

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n1 = Integer.parseInt(bufferedReader.readLine());
        int n2 = Integer.parseInt(bufferedReader.readLine());
        int n3 = Integer.parseInt(bufferedReader.readLine());
        int p_count = 0;
        int n_count = 0;

        if (n1 > 0) p_count++; else if(n1 < 0) n_count++;
        if (n2 > 0) p_count++; else if(n2 < 0) n_count++;
        if (n3 > 0) p_count++; else if(n3 < 0) n_count++;

        System.out.println("количество отрицательных чисел: "+n_count);
        System.out.println("количество положительных чисел: "+p_count);

    }
}
