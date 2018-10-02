package com.javarush.task.task38.task3803;

/* 
Runtime исключения (unchecked exception)
*/

import java.io.*;

public class VeryComplexClass {
    public void methodThrowsClassCastException() {
        Object obj = new String();
        Integer intgr = (Integer) obj;
    }

    public void methodThrowsNullPointerException() throws IOException {
        BufferedReader reader = null;
        reader.readLine();
    }

    public static void main(String[] args) {
        VeryComplexClass clazz = new VeryComplexClass();
        try {
            clazz.methodThrowsClassCastException();
            clazz.methodThrowsNullPointerException();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
