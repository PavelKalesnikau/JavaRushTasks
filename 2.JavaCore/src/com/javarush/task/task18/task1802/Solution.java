package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        int minByte = Byte.MAX_VALUE;
        FileInputStream fileInputStream = new FileInputStream(fileName);
        while (fileInputStream.available() > 0){
            int iByte = fileInputStream.read();
            if (minByte > iByte) minByte = iByte;
        }
        fileInputStream.close();
        System.out.println(minByte);
    }
}
