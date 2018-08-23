package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file_name1 = reader.readLine();
        String file_name2 = reader.readLine();
        String file_name3 = reader.readLine();

        FileInputStream fis1 = new FileInputStream(file_name1);
        FileOutputStream fos2 = new FileOutputStream(file_name2);
        FileOutputStream fos3 = new FileOutputStream(file_name3);

        int size_of_file = fis1.available();
        int half_of_file = size_of_file/2;

        byte[] buffer1 = new byte[size_of_file-half_of_file];
        byte[] buffer2 = new byte[half_of_file];

        fis1.read(buffer1, 0, size_of_file-half_of_file);
        fis1.read(buffer2, 0, fis1.available());

        fos2.write(buffer1);
        fos3.write(buffer2);

        fis1.close();
        fos2.close();
        fos3.close();
    }
}
