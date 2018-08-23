package com.javarush.task.task13.task1319;

import java.io.*;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = null;
        FileOutputStream fileOutputStream = null;
        try {
            // читаем полное имя файла с консоли
            // C:\temp\test-copy.txt
            String fileName = reader.readLine();
            fileOutputStream = new FileOutputStream(fileName);

            writer = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
            while (true){
                String line = reader.readLine();
                writer.write(line + System.lineSeparator());
                if (line.equals("exit")) break;
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null) fileOutputStream.close();
        }
        reader.close();
    }
}
