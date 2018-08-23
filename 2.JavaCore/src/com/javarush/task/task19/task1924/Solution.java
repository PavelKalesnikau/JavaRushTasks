package com.javarush.task.task19.task1924;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();
    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName)); // c:\temp\words4.txt
        while (bufferedReader.ready()){
            String line = bufferedReader.readLine();
            for (Map.Entry<Integer, String > entry: map.entrySet()) {
                // Более изящное решение, чем решение закоментированное внизу
                line = line.replaceAll("\\b" + entry.getKey() + "\\b", entry.getValue());  // \b - означает "совпадение на границе слова"
            }
            System.out.println(line);
        }
        /*
        while (bufferedReader.ready()) {
            String line = bufferedReader.readLine();
            String [] words = line.split(" ");
                for (String word : words ) {
                    for (Map.Entry<Integer, String > entry: map.entrySet()) {
                       word = word.replaceAll("^" + entry.getKey() + "$", entry.getValue());
                    }
                    System.out.print(word+" ");
                }

            System.out.println("");
        }
*/
        bufferedReader.close();
    }
}
