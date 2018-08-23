package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Осваивание статического блока
*/

public class Solution {
    public static void main(String[] args) {

    }
    
    static {
        //add your code here - добавьте код тут
        reset();
    }

    public static Flyable result;

    public static void reset() {
        //add your code here - добавьте код тут
        InputStreamReader isReader = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(isReader);

        try {
            String parameter = reader.readLine();
            if ("helicopter".equals(parameter)) result = new Helicopter();
            else if("plane".equals(parameter)) {
                int passengers = Integer.parseInt(reader.readLine());
                result = new Plane(passengers);
                isReader.close();
                reader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
