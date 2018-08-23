package com.javarush.task.task32.task3210;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) {
        String fileName = args[0];
        long number = Integer.parseInt(args[1]);
        String text = args[2];

        try {

            RandomAccessFile raf = new RandomAccessFile(fileName, "rw");

            byte[] readText = new byte[text.length()];
            raf.seek(number);
            raf.read(readText, 0, readText.length);

            boolean result = Arrays.equals(text.getBytes(), readText);

            String textToWrite;
            if (result) {
                textToWrite = "true";
            } else {
                textToWrite = "false";
            }
            raf.seek(raf.length());
            raf.write(textToWrite.getBytes());

            raf.close();
        } catch (IOException e) {
        }
    }
}
