package com.javarush.task.task07.task0708;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самая длинная строка
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> list = new ArrayList<String>();
        BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            String s = reader.readLine();
            list.add(s);
        }

        int max = list.get(0).length();
        for (int i = 1; i < list.size(); i++) if (max < list.get(i).length()) max = list.get(i).length();

        for (String s: list ) {
           if (s.length()== max) System.out.println(s);
        }
    }
}
