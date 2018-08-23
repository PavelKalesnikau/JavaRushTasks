package com.javarush.task.task08.task0817;

import java.util.HashMap;
import java.util.Map;

/* 
Нам повторы не нужны
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        HashMap<String, String> names = new HashMap<String, String>();
        names.put("Колесников", "Павел");
        names.put("Алешко", "Павел");
        names.put("Подлисских", "Павел");
        names.put("Мороз", "Павел");
        names.put("Вербило", "Сергей");
        names.put("Денисеня", "Сергей");
        names.put("Денисеня", "Николай");
        names.put("Талалаев", "Николай");
        names.put("Юрченко", "Алексей");
        names.put("Муравский", "Николай");
        names.put("Черкасюк", "Виталий");

        return names;

    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map) {
        HashMap<String, Integer> counts = new HashMap<String, Integer>();
        for (String name : map.values()) {
                if (counts.containsKey(name)) counts.merge(name, 1, Integer::sum);
                else counts.put(name,1);
           }
        for (Map.Entry<String, Integer> entry: counts.entrySet() ) {
            if (entry.getValue()>1) removeItemFromMapByValue(map, entry.getKey());
        }
    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value) {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args) {
        HashMap<String, String> map = createMap();
        removeTheFirstNameDuplicates(map);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }

    }
}
