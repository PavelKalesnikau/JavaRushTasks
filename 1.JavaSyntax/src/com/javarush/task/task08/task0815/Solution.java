package com.javarush.task.task08.task0815;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/* 
Перепись населения
*/

public class Solution {
    public static HashMap<String, String> createMap() {
            HashMap<String, String> names = new HashMap<String, String>();
            names.put("Колесников","Павел");
            names.put("Алешко","Павел");
            names.put("Подлисских","Павел");
            names.put("Мороз","Павел");
            names.put("Вербило","Сергей");
            names.put("Денисеня","Сергей");
            names.put("Денисеня","Николай");
            names.put("Талалаев","Николай");
            names.put("Юрченко","Алексей");
            names.put("Муравский","Николай");
            names.put("Черкасюк","Виталий");

        return names;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name) {
        Collection<String> names = map.values();
        int count = 0;
        for (String s:
             names) {
            if(s.equals(name)) count++;
        }
        return count;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName) {
        Collection<String> names = map.keySet();
        int count = 0;
        for (String s:
                names) {
            if(s.equals(lastName)) count++;
        }
        return count;
    }

    public static void main(String[] args) {
//        HashMap<String, String> names = createMap();
//        System.out.println(getCountTheSameFirstName(names,"Павел"));
//        System.out.println(getCountTheSameLastName(names, "Денисеня"));
    }
}
