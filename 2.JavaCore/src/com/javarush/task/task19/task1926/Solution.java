package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName)); // c:\temp\words4.txt
        while (bufferedReader.ready()) {
            String line = bufferedReader.readLine();
            StringBuilder sb = new StringBuilder(line);
            System.out.println(sb.reverse().toString());
        }
        bufferedReader.close();
    }
}
