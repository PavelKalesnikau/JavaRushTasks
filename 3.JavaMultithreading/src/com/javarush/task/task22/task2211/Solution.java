package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;

/* 
Смена кодировки
*/
public class Solution {
    public static void main(String[] args) throws IOException {

        if (args.length == 0) return;

        String fileName1 = args[0];
        String fileName2 = args[1];

        Charset w1251 = Charset.forName("Windows-1251");
        Charset utf8 = Charset.forName("UTF-8");

        FileInputStream fis = new FileInputStream(fileName1);
        byte[]buffer = new byte[fis.available()];
        fis.read(buffer);
        fis.close();

        String s = new String(buffer, w1251);
        buffer = s.getBytes(utf8); // преобразование в другую кодировку

        FileOutputStream fos = new FileOutputStream(fileName2);
        fos.write(buffer);
        fos.close();

    }
}
