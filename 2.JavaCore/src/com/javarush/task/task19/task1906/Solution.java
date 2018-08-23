package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;
import java.nio.CharBuffer;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();

        FileReader fileReader = new FileReader(fileName1);
        FileWriter fileWriter  = new FileWriter(fileName2);

        int index = 1;
        while (fileReader.ready()){
            int c = fileReader.read();
            if (index%2 == 0) fileWriter.write(c);
            index++;
        }
        fileReader.close();
        fileWriter.close();
    }
}
