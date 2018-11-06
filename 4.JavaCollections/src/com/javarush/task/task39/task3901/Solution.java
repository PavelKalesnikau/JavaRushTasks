package com.javarush.task.task39.task3901;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* 
Уникальные подстроки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please input your string: ");
        String s = bufferedReader.readLine();

        System.out.println("The longest unique substring length is: \n" + lengthOfLongestUniqueSubstring(s));
    }

    public static int lengthOfLongestUniqueSubstring(String s) {
        int max_length = 0;

        if (s == null) return 0;

        ArrayList<String> uniqueSubstrings = new ArrayList<String>();

        for (int i = 0; i < s.length(); i++) {
            HashSet<Character> set = new HashSet<>();
            int last = s.length();
            for (int j = i; j < s.length(); j++) {
                Character chr = s.charAt(j);
                if (set.contains(chr)){
                    last = j;
                    break;
                }else set.add(chr);
            }
            String substr = s.substring(i, last);
            if (substr.length() > max_length) max_length = substr.length();
            uniqueSubstrings.add(substr);
        }

        return max_length;

    }
}
