package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

/*        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        int count = 0;
        while (bufferedReader.ready()) {
            String line = bufferedReader.readLine();
            String[] words = line.split("[,.:;!?/' '()/[/]{}]");
            for (String word: words ) {
                if ("world".equals(word)) count++;
            }
        }

        fileReader.close();
        bufferedReader.close();

        System.out.println(count);*/

        FileReader fileReader = new FileReader(fileName);
        int count = 0;
        StringBuilder sb = new StringBuilder();
        ArrayList<String> list = new ArrayList<String>();

        while (fileReader.ready()) {
            int i = fileReader.read();

            if ((char) i != '\n' && (char) i != '\r') {
                sb.append((char) i);
            } else {
                String line = sb.toString();
                if (!line.isEmpty()) list.add(line);
                sb.delete(0, sb.length());
            }
        }

        list.add(sb.toString());

        for (String line : list) {
            String[] words = line.split("[,.:;!?/' '()/[/]{}]");
            for (String word : words) {
                if ("world".equals(word)) count++;
            }
        }

        fileReader.close();

        System.out.println(count);
    }
}
