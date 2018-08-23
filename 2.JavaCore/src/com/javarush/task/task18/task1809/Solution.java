package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file_name1 = reader.readLine();
        String file_name2 = reader.readLine();

        FileInputStream fis1 = new FileInputStream(file_name1);
        FileOutputStream fos2 = new FileOutputStream(file_name2);

        int size_of_file = fis1.available();

        byte[] buffer = new byte[size_of_file];

        fis1.read(buffer, 0, size_of_file);

        for (int i = size_of_file-1; i >=0 ; i--) {
            byte file_byte = buffer[i];
            fos2.write(file_byte);
        }

        fis1.close();
        fos2.close();
    }
}
