package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        String filename = args[0];

        FileInputStream fis = new FileInputStream(filename);
        int letters = 0;
        while (fis.available() > 0){
            int fbyte = fis.read();
            if ((fbyte >= 65 && fbyte <=90) || (fbyte >=97 && fbyte <= 122)) letters++;
        }
        System.out.println(letters);

        fis.close();
    }
}
