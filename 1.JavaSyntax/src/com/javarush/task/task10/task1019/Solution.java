package com.javarush.task.task10.task1019;

import java.io.*;
import java.util.HashMap;

/* 
Функциональности маловато!
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

//        int id = Integer.parseInt(reader.readLine());
//        String name = reader.readLine();
//
//        System.out.println("Id=" + id + " Name=" + name);

        HashMap<String, Integer> map = new HashMap<String, Integer>();
        while (true){
            String s = reader.readLine();
            if(s.isEmpty()) break;

            int number = Integer.parseInt(s);
            s = reader.readLine();

            map.put(s, number);
        }

        for ( HashMap.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getValue() + " " + entry.getKey());
        }
    }
}
