package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

// -e c:\temp\integers.txt c:\temp\integers_encr.txt
// -d c:\temp\integers_encr.txt c:\temp\integers_decr.txt
public class Solution {
    private static String fileName;
    private static String fileOutputName;
    private static FileInputStream fis;
    private static FileOutputStream fos;

    public static void main(String[] args) throws IOException {
    String key = args[0];
    fileName = args[1];
    fileOutputName = args[2];

        fis = new FileInputStream(fileName);
        fos = new FileOutputStream(fileOutputName);

        switch (key){
            case "-e":
                encrypt();
                break;
            case "-d":
                decrypt();
                break;
        }

        fis.close();
        fos.close();
    }

    static void encrypt() throws IOException {
        byte[] buffer = new byte[fis.available()];
        fis.read(buffer);
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] += 8; // encrypt
        }
        fos.write(buffer);
    }

    static void decrypt() throws IOException {
        byte[] buffer = new byte[fis.available()];
        fis.read(buffer);
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] -= 8; // decrypt
        }
        fos.write(buffer);
    }
}
