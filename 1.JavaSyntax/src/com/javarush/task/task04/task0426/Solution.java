package com.javarush.task.task04.task0426;

/* 
Ярлыки и числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        if( n < 0 && n%2 == 0) System.out.println("отрицательное четное число");
        else if( n < 0 && n%2 != 0) System.out.println("отрицательное нечетное число");
        else if( n == 0 ) System.out.println("ноль");
        else if( n > 0 && n%2 == 0) System.out.println("положительное четное число");
        else if( n > 0 && n%2 != 0) System.out.println("положительное нечетное число");

    }
}
