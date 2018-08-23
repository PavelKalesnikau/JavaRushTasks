package com.javarush.task.task14.task1419;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.*;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //it's first exception
        ArrayList<Integer> list = null;
        int[] array;
        byte b;
        Map<Integer, String> map = new TreeMap<>();

        //1
        try {
            float i = 1 / 0;
        } catch (Exception e) {
            exceptions.add(e);
        }
        //2
        try {
            array = new int[1];
            int i = array[1];
        } catch (Exception e) {
            exceptions.add(e);
        }
        //3
        try {
            int i = list.get(1);
        } catch (Exception e) {
            exceptions.add(e);
        }
        //4
        try {
            list = new ArrayList<Integer>();
            int i = list.get(1);
        } catch (Exception e) {
            exceptions.add(e);
        }
        //5
        try {
            Object o = "hello";
            list = new ArrayList<Integer>();
            list.add(1);
            list.add((Integer) o);
        } catch (Exception e) {
            exceptions.add(e);
        }
        //6
        try {
            int i = Integer.parseInt("kd");
            //or
            b = Byte.parseByte("256");
        } catch (Exception e) {
            exceptions.add(e);
        }
        //7
        try {
            FileInputStream inputStream = new FileInputStream("c:\temp");
            //or
            File file = new File("E://file.txt");
            FileReader fr = new FileReader(file);
        } catch (Exception e) {
            exceptions.add(e);
        }

        //8
        try {
            String ref = "Hello!";
            char c = ref.charAt(19);
        } catch (Exception e) {
            exceptions.add(e);
        }

        //9
        try {
            Class cl = "Example".getClass();
            String meth = "test";
            cl.getMethod(meth);
            System.out.println();

        } catch (Exception e) {
            exceptions.add(e);
        }

        //9
        try {
            Integer i = 0;
            Class cl = i.getClass();
            String field = "test";
            cl.getField(field);
            System.out.println();

        } catch (Exception e) {
            exceptions.add(e);
        }
    }
}
