package com.javarush.task.task01.task0132;

/* 
Сумма цифр трехзначного числа
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(sumDigitsInNumber(546));
    }

    public static int sumDigitsInNumber(int number) {
        int rNum = 0;
        for (int i = 0; i < 3; i++) {
            rNum +=  number%10;
            number /= 10;
        }
        return rNum;
    }
}