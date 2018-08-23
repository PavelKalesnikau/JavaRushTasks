package com.javarush.task.task03.task0320;


/* 
Скромность украшает программиста
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // Тимур зарабатывает $5,000. Ха-ха-ха!
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String name = bufferedReader.readLine();

        System.out.println(name + " зарабатывает $5,000. Ха-ха-ха!");
    }
}
