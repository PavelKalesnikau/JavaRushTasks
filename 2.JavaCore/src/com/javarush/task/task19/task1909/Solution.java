package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();

        FileReader fileReader = new FileReader(fileName1);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        ArrayList<String> lines = new ArrayList<String>();

        while (bufferedReader.ready()) {
            String line = bufferedReader.readLine();
            lines.add(line.replace('.', '!'));
        }
        fileReader.close();
        bufferedReader.close();

        FileWriter fileWriter = new FileWriter(fileName2);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        for (String line : lines ) {
            bufferedWriter.write(line+"\r\n");
        }

        bufferedWriter.close();
        fileWriter.close();
    }
}
