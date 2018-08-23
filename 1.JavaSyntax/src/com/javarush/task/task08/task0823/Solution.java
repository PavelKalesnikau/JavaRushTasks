package com.javarush.task.task08.task0823;

import jdk.nashorn.internal.runtime.regexp.RegExp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        //напишите тут ваш код


        String[] array = s.split("\\b"); // put into array all words in the string
        s = "";
        for (int i = 0; i < array.length; i++) {
            s+= array[i].substring(0,1).toUpperCase()+ array[i].substring(1);
        }

        System.out.println(s);
    }
}
