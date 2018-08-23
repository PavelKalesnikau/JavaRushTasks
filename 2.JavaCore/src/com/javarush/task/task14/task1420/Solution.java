package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n1 = Integer.parseInt(reader.readLine());
        int n2 = Integer.parseInt(reader.readLine());

        if (n1 < 0 || n2 < 0) throw new RuntimeException();
        System.out.println(findNod(n1, n2));

    }

   private static int findNod(int a, int b) {
        int nod = 1;
        int rest;
        if (a > b) {
            rest = a % b;
            if (rest == 0) return b;
            else return findNod(rest, b);
        } else {
            rest = b % a;
            if (rest == 0) return a;
            else return  findNod(a, rest);
        }
    }
}
