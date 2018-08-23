package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file_name1 = reader.readLine();
        String file_name2 = reader.readLine();
        reader.close();

        FileInputStream fis1 = new FileInputStream(file_name1);
        FileOutputStream fos2 = new FileOutputStream(file_name2);

        byte[] buffer1 = new byte[fis1.available()];
        fis1.read(buffer1);

        String line = new String(buffer1);
        String[] s_numbers = line.split(" ");

        for ( String number: s_numbers ) {
            long lnumber = Math.round(Double.parseDouble(number));
             fos2.write((lnumber + " ").getBytes());
        }

        fis1.close();
        fos2.close();
    }
}
