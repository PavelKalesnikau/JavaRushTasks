package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> list = new ArrayList<String>();
        BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();
            list.add(s);
        }

        int max = list.get(0).length();
        int ind_max = 0;
        for (int i = 1; i < list.size(); i++) {
            if (max < list.get(i).length()) {
                max = list.get(i).length();
                ind_max = i;
            }
        }

        int min = list.get(0).length();
        int ind_min = 0;
        for (int i = 1; i < list.size(); i++){
            if (min > list.get(i).length()) {
                min = list.get(i).length();
                ind_min = i;
            }
        }

        if (ind_min < ind_max) System.out.println(list.get(ind_min));
        else     System.out.println(list.get(ind_max));
    }
}
