package com.javarush.task.task15.task1523;

/* 
Перегрузка конструкторов
*/

public class Solution {
    public static void main(String[] args) {

    }

    private Solution(int i) {
    }
    Solution(Integer i) {
    }

    protected Solution(String s) {
    }
    public Solution(char c) {
    }

}

