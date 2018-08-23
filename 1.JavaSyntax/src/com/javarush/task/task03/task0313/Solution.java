package com.javarush.task.task03.task0313;

/* 
Мама мыла раму
*/

public class Solution {
    public static void main(String[] args) {
//      System.out.println("MaмаМылаРаму"); 0 1 2
//      System.out.println("MaмаРамуМыла"); 0 2 1
//      System.out.println("МылаМaмаРаму"); 1 0 2
//      System.out.println("МылаРамуМама"); 1 2 0
//      System.out.println("РамуМамаМыла"); 2 0 1
//      System.out.println("РамуМылаМама"); 2 1 0

        String s[] = {"Мама", "Мыла", "Раму" };
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++ )
                for (int z = 0; z < 3; z++ )
                    if(i!=j && i!=z && j!=z)
                        System.out.println(s[i]+s[j]+s[z]);
        }
    }
}
