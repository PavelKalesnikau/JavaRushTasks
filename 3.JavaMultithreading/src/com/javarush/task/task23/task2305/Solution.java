package com.javarush.task.task23.task2305;

/* 
Inner
*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {
        Solution [] solutions = new Solution[2];

        // solution 1
        Solution solution1 = new Solution();
        Solution.InnerClass innerClass1 = solution1.new InnerClass();
        Solution.InnerClass innerClass2 = solution1.new InnerClass();

        solution1.innerClasses[0] = innerClass1;
        solution1.innerClasses[1] = innerClass2;

        // solution 2
        Solution solution2 = new Solution();
        Solution.InnerClass innerClass3 = solution2.new InnerClass();
        Solution.InnerClass innerClass4 = solution2.new InnerClass();

        solution2.innerClasses[0] = innerClass3;
        solution2.innerClasses[1] = innerClass4;

        solutions[0] = solution1;
        solutions[1] = solution2;

        return solutions;
    }

    public static void main(String[] args) {

    }
}
