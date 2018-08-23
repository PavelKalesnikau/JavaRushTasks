package com.javarush.task.task08.task0821;

import java.util.HashMap;
import java.util.Map;

/* 
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleList();
        printPeopleList(map);
    }

    public static Map<String, String> createPeopleList() {
        Map<String, String> people = new HashMap<>();
        people.put("Гончаров", "Сергей"); //1
        people.put("Гончаров", "Михаил"); //2
        people.put("Иванов", "Михаил"); //3
        people.put("Иванов", "Дмитрий"); //4
        people.put("Южный", "Дмитрий"); //5
        people.put("Северный", "Павел"); //6
        people.put("Южный", "Александр"); //7
        people.put("Западный", "Александр"); //8
        people.put("Восточный", "Юрий"); //9
        people.put("Западный", "Юрий"); //10

        return people;
    }

    public static void printPeopleList(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
