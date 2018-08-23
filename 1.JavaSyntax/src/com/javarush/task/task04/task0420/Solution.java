package com.javarush.task.task04.task0420;

/* 
Сортировка трех чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        int n1 = Integer.parseInt(s);
        s = bufferedReader.readLine();
        int n2 = Integer.parseInt(s);
        s = bufferedReader.readLine();
        int n3 = Integer.parseInt(s);

        if (n1 > n2 && n2 > n3) System.out.println(n1 + " " + n2 + " " + n3);
        else if (n1 >= n3 && n3 >= n2) System.out.println(n1 + " " + n3 + " " + n2);
        else if (n2 >= n1 && n1 >= n3) System.out.println(n2 + " " +  n1 + " " + n3);
        else if (n2 >= n3 && n3 >= n1) System.out.println(n2 + " " + n3+ " " + n1);
        else if (n3 >= n1 && n1 >= n2) System.out.println(n3 + " " + n1+ " " + n2);
        else if (n3 >= n2 && n2 >= n1) System.out.println(n3 + " " + n2+ " " + n1);
        else System.out.println(n1 + " " + n2+ " " + n3);
    }
}
