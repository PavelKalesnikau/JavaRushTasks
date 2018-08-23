package com.javarush.task.task04.task0416;

/* 
Переходим дорогу вслепую
*/

//import javax.xml.bind.SchemaOutputResolver;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String s = bufferedReader.readLine();
        double t = Double.parseDouble(s);
        int d = (int) t % 5;
        if (d == 0 || d == 1 || d == 2) System.out.println("зелёный");
        else if (d == 3) System.out.println("желтый");
        else System.out.println("красный");

//        double t;
//        do {
//
//            String s = bufferedReader.readLine();
//            t = Double.parseDouble(s);
//            int d = (int) t % 5;
//            if (d == 0 || d == 1 || d == 2) System.out.println("зеленый");
//            else if (d == 3) System.out.println("желтый");
//            else System.out.println("красный");
//
//        } while (t != -1);

    }
}