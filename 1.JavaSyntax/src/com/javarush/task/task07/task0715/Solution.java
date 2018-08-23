package com.javarush.task.task07.task0715;

import java.util.ArrayList;
import java.util.Collections;

/* 
Продолжаем мыть раму
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> list = new ArrayList<String>();
        ArrayList<String> new_list = new ArrayList<String>();
        Collections.addAll(list, "мама", "мыла", "раму");

        list.add(1, "именно");
        list.add(3, "именно");
        list.add(5, "именно");

        for (int i = 0; i < list.size(); i++) System.out.println(list.get(i));

    }
}
