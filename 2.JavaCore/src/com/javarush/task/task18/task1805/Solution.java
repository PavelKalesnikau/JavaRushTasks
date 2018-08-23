package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        ArrayList<Integer> listBytes = new ArrayList<Integer>();


        FileInputStream fileInputStream = new FileInputStream(fileName);
        while (fileInputStream.available() > 0) {
            int iByte = fileInputStream.read();

            if (!listBytes.contains(iByte)) {
                listBytes.add(iByte);
            }
        }
        fileInputStream.close();

        Integer[] array = listBytes.toArray(new Integer[listBytes.size()]);

        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int ibyte = array[i];
                    array[i] = array[j];
                    array[j] = ibyte;
                }
            }
        }
        for (int i : array ) {
            System.out.print(i + " ");
        }
    }
}
