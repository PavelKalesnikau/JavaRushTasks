package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Играем в Jолушку
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> mainList = new ArrayList<Integer>();
        ArrayList<Integer> list3 = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        ArrayList<Integer> listRest = new ArrayList<Integer>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 20; i++) {
            String s = reader.readLine();
            if (s.isEmpty()) continue;
            mainList.add(Integer.parseInt(s));
        }

        for (int i = 0; i < mainList.size(); i++) {
            if (mainList.get(i) % 3 == 0) list3.add(mainList.get(i));
            if (mainList.get(i) % 2 == 0) list2.add(mainList.get(i));
            else if (mainList.get(i) % 3 != 0) listRest.add(mainList.get(i));
        }
        // print lists
        printList(mainList);
        printList(list3);
        printList(list2);
        printList(listRest);

    }


    public static void printList(List<Integer> list) {
        for (int i :
                list) {
            System.out.println(i);
        }
    }
}
