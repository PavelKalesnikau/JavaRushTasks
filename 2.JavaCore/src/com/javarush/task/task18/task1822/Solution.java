package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        /* Мой блок. Работает. Не проходит валидатор. */

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file_name = reader.readLine();
        reader.close();
/*
        FileInputStream fis = new FileInputStream(file_name);
        byte[] buffer = new byte[fis.available()];
        fis.read(buffer);
        fis.close();

        String file = new String(buffer);
        String[] lines = file.split("\\r\\n");

        for (String line : lines) {
            if (line == null) break;
            if (args[0].equals(line.split(" ")[0])) {
                System.out.println(line);
                break;
            };
        }*/


        /* Решение из интернета. */

        //Программа запускается с одним параметром: id (int).
        int id = Integer.parseInt(args[0]);

        //Найти в файле информацию, которая относится к заданному id, и вывести ее на экран в виде, в котором она записана в файле.
        BufferedReader br = new BufferedReader(new FileReader(file_name));
        while (true) {
            String s = br.readLine();
            if (s == null) {
                break;
            }
            if (id == Integer.parseInt(s.split(" ")[0])) {
                System.out.println(s);
                br.close();
                break;
            }
        }
    }
}
