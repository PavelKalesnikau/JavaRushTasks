package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileName = reader.readLine();
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(fileName);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader fileReader = new BufferedReader(inputStreamReader);
            String line;
            ArrayList<Integer> numbers = new ArrayList<Integer>();
            while ((line = fileReader.readLine())!=null) {
                int number = Integer.parseInt(line);
                if (number%2 == 0) numbers.add(number);
            }
            fileReader.close();

            //sort
            Integer[] array = numbers.toArray(new Integer[numbers.size()]);
            for (int i = 0; i < array.length; i++) {
                for (int j = i; j < array.length; j++) {
                   if (array[i] > array[j]) {
                       int n = array[i];
                       array[i] = array[j];
                       array[j] = n;
                   }
                }
            }

            for (int i:array  ) {
                System.out.println(i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } finally {
            fileInputStream.close();
        }
    }
}
