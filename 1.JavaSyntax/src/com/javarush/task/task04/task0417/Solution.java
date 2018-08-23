package com.javarush.task.task04.task0417;

/* 
Существует ли пара?
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        int a = Integer.parseInt(s);
        s = bufferedReader.readLine();
        int b = Integer.parseInt(s);
        s = bufferedReader.readLine();
        int c = Integer.parseInt(s);

        if (a == b && a == c && b == c) System.out.println(a + " " + b + " " + c);
        else if ( a == c ) System.out.println(a + " " + c);
        else if ( a == b ) System.out.println(a + " " + b);
        else if ( b == c ) System.out.println(b + " " + c);
    }
}