package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        HashMap<Integer, Integer> mapBytes = new HashMap<Integer, Integer>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        FileInputStream fileInputStream = new FileInputStream(fileName);
        while (fileInputStream.available() > 0) {
            int iByte = fileInputStream.read();

            if (mapBytes.containsKey(iByte)) {
                int i = mapBytes.get(iByte);
                mapBytes.put(iByte, i + 1);
            } else {
                mapBytes.put(iByte, 1);
            }
        }
        fileInputStream.close();

        int maxByte_count = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry : mapBytes.entrySet()) {
            if (maxByte_count < entry.getValue())
                maxByte_count = entry.getValue();
        }
        for (Map.Entry<Integer, Integer> entry : mapBytes.entrySet()) {
            if (maxByte_count == entry.getValue()) System.out.print(entry.getKey() + " ");
        }
    }
}
