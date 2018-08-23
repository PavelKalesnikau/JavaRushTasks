package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {

        FileInputStream fis = new FileInputStream(args[0]); // берем имя файла из первого аргумента программы
        int all_letters = 0;                                // количество всех символов
        int spaces = 0;                                     // количество пробелов
        while (fis.available() > 0) {
            int fbyte = fis.read();
            all_letters++;
            if ( fbyte == 32 )                              // ASCII код пробела
                spaces++;
        }
        fis.close();                                        // закрываем поток

        System.out.println(String.format("%(.2f",(float)spaces/all_letters*100)); // выводим процентное соотношение пробелов ко всем символам в файле

    }
}
