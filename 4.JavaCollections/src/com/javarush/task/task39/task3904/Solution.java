package com.javarush.task.task39.task3904;

import java.util.HashMap;

/* 
Лестница
*/
public class Solution {
    private static int n = 70;
    private static HashMap<Integer, Long> tribonachi = new HashMap<>();
    static{
        tribonachi.put(0,1L);
        tribonachi.put(1,1L);
        tribonachi.put(2,2L);
        tribonachi.put(3,4L);
    }
    public static void main(String[] args) {
        System.out.println("Number of possible runups for " + n + " stairs is: " + countPossibleRunups(n));
    }


    public static long countPossibleRunups(int n) {
        if (n == 0) return 1;
        if (n < 0) return 0;

        if (tribonachi.containsKey(n)) return tribonachi.get(n);
        else{
            long val = countPossibleRunups(n-1)+countPossibleRunups(n-2)+countPossibleRunups(n-3);
            tribonachi.put(n,val);
            return val;
        }
    }
}

