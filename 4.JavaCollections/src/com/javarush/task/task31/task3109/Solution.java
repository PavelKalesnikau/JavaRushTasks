package com.javarush.task.task31.task3109;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/* 
Читаем конфиги
*/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Properties properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/properties.xml");
        properties.list(System.out);

        properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/properties.txt");
        properties.list(System.out);

        properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/notExists");
        properties.list(System.out);
    }

    public Properties getProperties(String fileName) {
        try (FileInputStream fis = new FileInputStream(fileName)) {
            Properties properties = new Properties();
            if (fileName.endsWith(".xml")) {
                properties.loadFromXML(fis);
            } else {
                properties.load(fis);
            }

            return properties;

        } catch (FileNotFoundException e) {
            return new Properties();
        } catch (IOException e) {
            return new Properties();
        }

    }
}
