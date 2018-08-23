package com.javarush.task.task08.task0814;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* 
Больше 10? Вы нам не подходите
*/

public class Solution {
    public static HashSet<Integer> createSet() {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 1; i <= 20; i++) {
            set.add(i);
        }
        return set;
    }

    public static HashSet<Integer> removeAllNumbersMoreThan10(HashSet<Integer> set) {
        for (Iterator<Integer> it = set.iterator(); it.hasNext();){
            int i = it.next();
            if (i>10)
                it.remove();
        }
        return set;
    }

    public static void main(String[] args) {
//        HashSet<Integer> set = createSet();
//        set = removeAllNumbersMoreThan10(set);
//        for (int i:
//             set) {
//            System.out.println(i);
//        }
    }
}
