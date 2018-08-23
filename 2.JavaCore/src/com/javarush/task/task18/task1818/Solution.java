package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file_name1 = reader.readLine();
        String file_name2 = reader.readLine();
        String file_name3 = reader.readLine();

        FileOutputStream fos1 = new FileOutputStream(file_name1);
        FileInputStream fis2 = new FileInputStream(file_name2);
        FileInputStream fis3 = new FileInputStream(file_name3);

        int size_of_file2 = fis2.available();
        int size_of_file3 = fis3.available();

        byte[] buffer2 = new byte[size_of_file2];
        byte[] buffer3 = new byte[size_of_file3];

        fis2.read(buffer2, 0, size_of_file2);
        fis3.read(buffer3, 0, size_of_file3);

        fos1.write(buffer2);
        fos1.write(buffer3);

        fos1.close();
        fis2.close();
        fis3.close();

    }
}
