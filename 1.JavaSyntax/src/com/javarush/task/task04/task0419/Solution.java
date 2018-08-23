package com.javarush.task.task04.task0419;

/* 
Максимум четырех чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int max = 0;
//        for (int i = 0; i < 4; i++) {
//            String s = bufferedReader.readLine();
//            int n = Integer.parseInt(s);
//            if ( n >= max) max = n;
//        }
        String s = bufferedReader.readLine();
        int n1 = Integer.parseInt(s);
        s = bufferedReader.readLine();
        int n2 = Integer.parseInt(s);
        s = bufferedReader.readLine();
        int n3 = Integer.parseInt(s);
        s = bufferedReader.readLine();
        int n4 = Integer.parseInt(s);

        max = n1;
        if (n2 >= max) max = n2;
        if( n3 >= max) max = n3;
        if( n4 >= max) max = n4;
        System.out.println(max);
    }
}
