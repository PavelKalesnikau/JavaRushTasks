package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.TreeSet;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        TreeSet<String> file_parts = new TreeSet<String>();
        while (true) {
            String fileName = reader.readLine();
            if (fileName.equals("end")) break;
            file_parts.add(fileName);
        }
        reader.close();

        String full_fileName = file_parts.first().split("[.]")[0] +"."+ file_parts.first().split("[.]")[1];

        FileOutputStream fos = new FileOutputStream(full_fileName);
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        for (String fileName : file_parts) {
            FileInputStream fis = new FileInputStream(fileName);
            BufferedInputStream bis = new BufferedInputStream(fis);
            byte[] buffer = new byte[bis.available()];
            bis.read(buffer);
            bos.write(buffer);
            bis.close();
            fis.close();
        }
        bos.close();
        fos.close();
    }
}
