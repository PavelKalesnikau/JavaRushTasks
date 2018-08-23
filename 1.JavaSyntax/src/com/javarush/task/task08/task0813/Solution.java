package com.javarush.task.task08.task0813;

import java.util.HashSet;

/* 
20 слов на букву «Л»
*/

public class Solution {
    public static HashSet<String> createSet() {
        HashSet<String> set = new HashSet<String>();
        set.add("Любовь"); set.add("Лиза");
        set.add("Лада");  set.add("Лола");
        set.add("Ложка");  set.add("Ламинария");
        set.add("Лыжа");  set.add("Легко");
        set.add("Люмен");  set.add("Лазать");
        set.add("Лара");  set.add("Лежать");
        set.add("Лотарингия"); set.add("Лапа");
        set.add("Лев"); set.add("Лиловый");
        set.add("Лось");    set.add("Лили");
        set.add("Леопольд");    set.add("Лала");

        return set;
    }

    public static void main(String[] args) {
        createSet();
    }
}
