package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public static void main(String[] args) {
        try {
            new Solution().fillInPropertiesMap();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void fillInPropertiesMap() throws Exception {
        //implement this method - реализуйте этот метод
        // 1. читаем имя файла с консоли
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine(); // c:\temp\test.properties
        reader.close();

        //2. Читаем и пишем файл в FileInputStream/FileOutputStream
        FileInputStream fileInputStream = new FileInputStream(fileName);
        load(fileInputStream);
        fileInputStream.close();

        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        save(fileOutputStream);
        fileOutputStream.close();

    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties props = new Properties();
        props.putAll(properties);
//        props.store(outputStream, new Date().toString());
        props.store(outputStream, "Store properties is called");
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties props = new Properties();
        props.load(inputStream);
        for ( Map.Entry property: props.entrySet()) {
            properties.put(property.getKey().toString(), property.getValue().toString()) ;
        }

    }
}
