package com.javarush.task.task04.task0437;


/* 
Треугольник из восьмерок
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        int m = 10;
        int n = 1;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                System.out.print("8");
            }
            n++;
            System.out.println("");
        }
    }
}
