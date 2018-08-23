package com.javarush.task.task20.task2028;

import java.util.List;

public class Solution {
    public static void main(String[] args) {
        List<String> list = new CustomTree();

        for (int i = 1; i < 16; i++) {
            list.add(String.valueOf(i));
        }

        System.out.println("List size is " + list.size());
        System.out.println("Expected parent is 3, actual parent is " + ((CustomTree) list).getParent("8"));
        System.out.println("Expected parent is null, actual parent is " + ((CustomTree) list).getParent("20"));

        list.remove("3");
        System.out.println("Expected parent is null, actual parent is " + ((CustomTree) list).getParent("8"));
        System.out.println("Размер дерева (ожидаемо 11): " + list.size());

        list.add("16");
        System.out.println("Expected parent is 9, actual parent is " + ((CustomTree) list).getParent("16"));
        System.out.println("Размер дерева: " + list.size());

        list.remove("4");
        list.remove("5");
        list.remove("6");
        System.out.println("Размер дерева: " + list.size());
        System.out.println("Expected true, actual " + list.add("20"));
        System.out.println("Expected parent is 1, actual parent is " + ((CustomTree) list).getParent("20"));
        System.out.println("Expected true, actual " + list.add("21"));
        System.out.println("Expected true, actual " + list.add("22"));
        System.out.println("Expected true, actual " + list.add("23"));
        System.out.println("Размер дерева: " + list.size());

        System.out.println("Expected true, actual " + list.add("24")); // parent = 20
        System.out.println("Expected true, actual " + list.add("25")); // parent = 20
        System.out.println("Expected true, actual " + list.add("26")); // parent = 21
        System.out.println("Expected true, actual " + list.add("27")); // parent = 21
        System.out.println("Expected true, actual " + list.add("28")); // parent = 22
        System.out.println("Expected true, actual " + list.add("29")); // parent = 22
        System.out.println("Expected true, actual " + list.add("30")); // parent = 23
        System.out.println("Expected true, actual " + list.add("31")); // parent = 23
        System.out.println("Размер дерева: " + list.size());

        list.remove("20");
        System.out.println("Размер дерева: " + list.size());
        System.out.println("Expected true, actual " + list.add("32"));
        System.out.println("Expected parent is 26, actual parent is " + ((CustomTree) list).getParent("32"));

        list.remove("21");
        list.remove("22");
        list.remove("30");
        System.out.println("Размер дерева: " + list.size());
        System.out.println("Expected true, actual " + list.add("33"));
        System.out.println("Expected parent is 31, actual parent is " + ((CustomTree) list).getParent("33"));
        list.remove("23");
        System.out.println("Рзмер дерева: " + list.size());

        System.out.println("Expected true, actual " + list.add("33"));
        System.out.println("Expected parent is 1, actual parent is " + ((CustomTree) list).getParent("33"));
        System.out.println("Рзмер дерева: " + list.size());
    }
}
