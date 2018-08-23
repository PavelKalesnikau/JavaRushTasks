package com.javarush.task.task07.task0718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Проверка на упорядоченность
*/
public class Solution {
//    public static void main(String[] args) throws IOException {
//        ArrayList<String> list = new ArrayList<String>();
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        for (int i = 0; i < 10; i++) {
//            list.add(reader.readLine());
//        }
//
//        int len = list.get(0).length();
//        for (int i = 1; i < list.size(); i++) {
//            if( list.get(i).length() < len) { System.out.println(i); break; }
//            else len = list.get(i).length();
//        }
//    }
    public static void main(String[] args) throws IOException{
        Integer a = new Integer(1);
        Integer b = new Integer(1);
        System.out.println(a>b);
        System.out.println(a<b);
        System.out.println(a==b);
        System.out.println(a.equals(b));
    }
}


