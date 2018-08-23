package com.javarush.task.task19.task1910;

/* 
Пунктуация
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
            // Мой способ удаления знаков препинания. Не прошел валидатор! Видимо, не учитывает все возможные знаки пунктуации.
            // lines.add(line.replaceAll("[ ,;:.?!(){}\"-]",""));

            // Ниже более изящный способ удаления всех знаков пунктуации (куда входит и пробел!), а также переход на новую строку
            // решение найдено в интернете
              lines.add(line.replaceAll("[\\p{P} \\t\\n\\r]",""));
        }
        fileReader.close();
        bufferedReader.close();

        FileWriter fileWriter = new FileWriter(fileName2);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        for (String line : lines ) {
            bufferedWriter.write(line);
        }

        bufferedWriter.close();
        fileWriter.close();
    }
}
