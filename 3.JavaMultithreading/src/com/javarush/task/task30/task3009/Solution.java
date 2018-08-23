package com.javarush.task.task30.task3009;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* 
Палиндром?
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getRadix("112"));        //expected output: [3, 27, 13, 15]
        System.out.println(getRadix("123"));        //expected output: [6]
        System.out.println(getRadix("5321"));       //expected output: []
        System.out.println(getRadix("1A"));         //expected output: []
    }
    private static Set<Integer> getRadix(String number){
        try {
            Set<Integer> polyndromSet = new HashSet<Integer>();
            Integer numberInDex = Integer.parseInt(number);
            for (int i = 2; i < 37; i++) {
                StringBuilder sb = new StringBuilder(Integer.toString(numberInDex, i));
                StringBuilder sb_rev = new StringBuilder(sb);
                sb_rev.reverse();
                if (sb_rev.toString().equals(sb.toString()))
                    polyndromSet.add(i);
            }
            return polyndromSet;
        } catch (NumberFormatException e) {
            return Collections.emptySet();
        }
    }
}