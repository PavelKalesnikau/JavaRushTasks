package com.javarush.task.task34.task3403;

/* 
Разложение на множители с помощью рекурсии
*/
public class Solution {
    public void recursion(int n) {
       int d = 2;
       if (n == 1) return;
       while (n%d != 0) d++;
       System.out.printf("%d ", d);
       recursion(n/d);
    }

    public static void main(String[] args) {
        new Solution().recursion(132);
    }
}
