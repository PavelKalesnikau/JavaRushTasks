package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) return;

        String fileName = args[0];
        // c:\temp\names.txt
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

        SortedMap<String, Double> sortedMap = new TreeMap<>();
        for (String line : file) {
            String[] words = line.split(" ");
            sortedMap.merge(words[0], Double.valueOf(words[1]), (a, b) -> a + b);
        }
        for (Map.Entry<String, Double> entry : sortedMap.entrySet() ) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        fileReader.close();
    }
}
