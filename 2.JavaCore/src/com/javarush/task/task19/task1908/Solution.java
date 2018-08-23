package com.javarush.task.task19.task1908;

/* 
Выделяем числа
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
        ArrayList<String> numbers = new ArrayList<String>();

        while (bufferedReader.ready()) {
            String line = bufferedReader.readLine();
            String[] words = line.split("[,.:;!?/' '()/[/]{}]");
            for (String word: words ) {
                if (isNumber(word)) numbers.add(word);
            }
        }
        fileReader.close();
        bufferedReader.close();

        FileWriter fileWriter = new FileWriter(fileName2);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        for (String number : numbers ) {
            bufferedWriter.write( number + " ");
        }

        bufferedWriter.close();
        fileWriter.close();
    }
    private static boolean isNumber (String word){
        try {
            double d = Double.parseDouble(word);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
