package com.javarush.task.task32.task3202;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

/* 
Читаем из потока
*/
public class Solution {
    public static void main(String[] args) throws IOException {
//        StringWriter writer = getAllDataFromInputStream(new FileInputStream("testFile.log"));
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("c:\\temp\\Tests\\afile1.txt"));
        System.out.println(writer.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {
        StringWriter sw = new StringWriter();
        int b;

        if(is == null) return sw;

        while ((b = is.read()) != -1) {
            sw.write(b);
        }
        return sw;
    }
}