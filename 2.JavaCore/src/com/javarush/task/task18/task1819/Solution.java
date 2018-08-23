package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file_name1 = reader.readLine();
        String file_name2 = reader.readLine();

        FileOutputStream fos1 = new FileOutputStream(file_name1);
        FileInputStream fis1 = new FileInputStream(file_name1);
        FileInputStream fis2 = new FileInputStream(file_name2);

        int size_of_file1 = fis1.available();
        int size_of_file2 = fis2.available();

        byte[] buffer1 = new byte[size_of_file1];
        byte[] buffer2 = new byte[size_of_file2];

        fis1.read(buffer1, 0, size_of_file1);
        fis2.read(buffer2, 0, size_of_file2);

        fos1.write(buffer2);
        fos1.write(buffer1);

        fos1.close();
        fis1.close();
        fis2.close();
    }
}
