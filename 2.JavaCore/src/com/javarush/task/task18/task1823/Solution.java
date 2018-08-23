package com.javarush.task.task18.task1823;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        while (true) {
            line = reader.readLine();
            if (line.equals("exit")) break;
            ReadThread readThread = new ReadThread(line);
            readThread.start();
        }
        reader.close();

        System.out.println(resultMap);
    }

    public static class ReadThread extends Thread {
        String fileName;

        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут

        @Override
        public void run() {
            try {
                FileInputStream fis = new FileInputStream(fileName);
                byte[] bytes = new byte[fis.available()];

                fis.read(bytes);
                fis.close();

                int max_byte = bytes[0];
                int max_occurs = Integer.MIN_VALUE;
                for (int i = 0; i < bytes.length; i++) {
                    int current_occurs = 0;
                    for (int j = 0; j < bytes.length; j++) {
                        if (bytes[i] == bytes[j]) current_occurs++;
                    }
                    if (max_occurs < current_occurs) {
                        max_occurs = current_occurs;
                        max_byte = bytes[i];
                    }
                }
//                synchronized (resultMap){
                    resultMap.put(fileName, max_byte);
//                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
