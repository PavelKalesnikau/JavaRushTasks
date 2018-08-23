package com.javarush.task.task07.task0714;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* 
Слова в обратном порядке
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> list = new ArrayList<String>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            String s = reader.readLine();
            if (s.isEmpty()) continue;
            list.add(s);
        }

        list.remove(2);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(list.size()-i-1));
        }
    }
}


