package com.javarush.task.task06.task0606;

import java.io.*;

/* 
Чётные и нечётные циферки
*/

public class Solution {

    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        do{
            int p = n%10;
            if (p%2 == 0) even++;
            else odd++;
            n/=10;

        }while (n != 0);
        System.out.println("Even: "+ even + " Odd: " + odd);
    }
}
