package com.javarush.task.task15.task1516;

/* 
Значения по умолчанию
*/

public class Solution {
    public int intVar;
    public double doubleVar;
    public Double DoubleVar;
    public boolean booleanVar;
    public Object ObjectVar;
    public Exception ExceptionVar;
    public String StringVar;

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.print(solution.intVar + " ");
        System.out.print(solution.doubleVar + " ");
        System.out.print(solution.DoubleVar + " ");
        System.out.print(solution.booleanVar + " ");
        System.out.print(solution.ObjectVar + " ");
        System.out.print(solution.ExceptionVar + " ");
        System.out.print(solution.StringVar);
    }
}
