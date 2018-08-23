package com.javarush.task.task32.task3213;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/* 
Шифр Цезаря
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringReader reader = new StringReader("Khoor#Dpljr#&C,₷B'3");
        System.out.println(decode(reader, -3));  //Hello Amigo #@)₴?$0
    }

    public static String decode(StringReader reader, int key) throws IOException {
/*  мое решение работает, но не проходит последнее 3-е условие
        StringWriter swDecoded = new StringWriter();
            int letter;
        try {
            while ((letter = reader.read()) != -1){
                int decodedLetter = letter + key;
                swDecoded.write(decodedLetter);
            }
        } catch (IOException e) {
            return new String();
        }
        return swDecoded.toString();
*/
        int a;
        StringBuffer res = new StringBuffer();

        try {
            while ((a = reader.read()) != -1) {
                res.append(Character.toString((char) (a + key)));
            }
        } catch (Exception e) {
            return new String();
        }

        return res.toString();
    }
}
