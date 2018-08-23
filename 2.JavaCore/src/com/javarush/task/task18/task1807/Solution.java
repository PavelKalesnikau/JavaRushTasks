package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file_name = reader.readLine();

       FileInputStream fis = new FileInputStream(file_name);

       int commas = 0;
       while (fis.available()>0){
           int iByte = fis.read();
           // работает в обоих случаях
//            if (iByte == ',') commas++;
            if (iByte == 44) commas++; // 44 - код ','
       }
        System.out.println(commas);
        fis.close();
        reader.close();
    }
}
