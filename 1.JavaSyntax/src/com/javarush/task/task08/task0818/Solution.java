package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        HashMap<String, Integer> names = new HashMap<String, Integer>();
        names.put("Василевский", 540);
        names.put("Алешко", 550);
        names.put("Подлисских", 300);
        names.put("Мороз", 250);
        names.put("Вербило", 400);
        names.put("Денисеня", 200);
        names.put("Денисеня", 100);
        names.put("Талалаев", 1000);
        names.put("Юрченко", 400);
        names.put("Муравский", 100);
        names.put("Черкасюк", 240);

        return names;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        HashSet<String> names = new HashSet<String>();
        for (Map.Entry<String, Integer> entry: map.entrySet() ) {
            if( entry.getValue() < 500) names.add(entry.getKey());
        }
        for (String name: names
             ) {
            map.remove(name);
        }
    }

    public static void main(String[] args) {
//        HashMap<String, Integer> map = createMap();
//        removeItemFromMap(map);
//        for (Map.Entry<String, Integer> entry : map.entrySet()) {
//            System.out.println(entry.getKey() + " - " + entry.getValue());
//        }
    }
}