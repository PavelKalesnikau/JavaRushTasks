package com.javarush.task.task07.task0716;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Р или Л
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> list = new ArrayList<String>();
        list.add("роза"); //0
        list.add("лоза"); //1
        list.add("лира"); //2
        list = fix(list);

        for (String s : list) {
            System.out.println(s);
        }
    }

    public static ArrayList<String> fix(ArrayList<String> list) {
        ArrayList<String> temp = new ArrayList<String>();

        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);

            if(s.contains("р") && !s.contains("л")) continue;
            else if(s.contains("л") && !s.contains("р")) { temp.add(s); temp.add(s); }
            else temp.add(s);
        }

        return temp;
    }
}