package com.javarush.task.task05.task0529;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Консоль-копилка
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int summ = 0;
        while (true){
            String s = bufferedReader.readLine();
            if (s.equals("сумма")) break;
            summ += Integer.parseInt(s);
        }
        System.out.println(summ);
    }
}
