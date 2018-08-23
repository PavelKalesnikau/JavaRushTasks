package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        //c:\temp\words2.txt
        FileReader fileReader = new FileReader(fileName);
        // Read entire file into ArrayList with help of FileReader
        ArrayList<String> file = new ArrayList<String>();
        StringBuilder contentBuilder = new StringBuilder();
        while (fileReader.ready()) {
            int i = fileReader.read();
            if (i != 10 && i != 13) contentBuilder.append((char) i);
            else {
                if (i == 10) {
                    file.add(contentBuilder.toString());
                    contentBuilder.delete(0, contentBuilder.length());
                }
            }
        }
        file.add(contentBuilder.toString()); // put the last string into ArrayList
        fileReader.close();

        // Look for strings, that fit to requirement

        for (String line: file  ) {
            int count = 0;
            for (String word: words ) {
                if (line.contains(word)) count++;
            }
            if (count == 2) System.out.println(line);
        }
    }
}
