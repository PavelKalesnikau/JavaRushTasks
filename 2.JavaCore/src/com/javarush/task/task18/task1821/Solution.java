package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.*;
import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fis1 = new FileInputStream(args[0]);
        byte[] buffer1 = new byte[fis1.available()];
        fis1.read(buffer1);

        SortedMap<Byte, Integer> sortedMap = new TreeMap<Byte, Integer>(new Comparator<Byte>() {
            @Override
            public int compare(Byte o1, Byte o2) {
                if (o1 > o2) return 1;
                else if(o1 < o2) return -1;
                else return 0;
            }
        });

        for (int i = 0; i < buffer1.length; i++) {
            byte codePoint = buffer1[i];
            sortedMap.compute(codePoint, (k, v) -> (v == null) ? 1 : v+1);
           // sortedMap.merge(codePoint, 1, (a, b) -> a + b); // Этот вариант тоже работает!!!
        }
        for (Map.Entry<Byte, Integer> entry: sortedMap.entrySet()) {
            System.out.println(new String(new byte[] {entry.getKey(), 32}) + entry.getValue());
        }
        fis1.close();
    }
}
