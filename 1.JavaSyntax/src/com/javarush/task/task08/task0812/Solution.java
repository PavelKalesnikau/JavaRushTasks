package com.javarush.task.task08.task0812;

import java.io.*;
import java.util.ArrayList;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    ArrayList<Integer> numbers = new ArrayList<Integer>();

    for (int i = 0; i < 10; i++) numbers.add(Integer.parseInt(reader.readLine()));

    int max_length = 0;
        for (int i = 0; i < numbers.size(); i++) {
            int number = numbers.get(i);
            int count = 0;
            for (int j = i; j < numbers.size(); j++) {
                if (number == numbers.get(j)) count++;
                else break;
            }
            if (max_length < count) max_length = count;
        }

        System.out.println(max_length);
    }
}