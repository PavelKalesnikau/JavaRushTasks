package com.javarush.task.task36.task3605;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;

/* 
Использование TreeSet
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName = args[0];
        FileReader fileReader = new FileReader(fileName);
        BufferedReader reader = new BufferedReader(fileReader);
        TreeSet<Character> set = new TreeSet();
        while (reader.ready()) {
            String line = reader.readLine();
            for (int i = 0; i < line.length(); i++) {
                char c = line.toLowerCase().charAt(i);
                if (c >= 'a' && c < 'z') set.add(c);
            }
        }

        int size = set.size() < 5 ? set.size() : 5;
        for (int i = 0; i < size; i++) {
            System.out.print(set.pollFirst());
        }
    }
}
