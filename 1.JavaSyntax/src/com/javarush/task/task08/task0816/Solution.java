package com.javarush.task.task08.task0816;

import java.util.*;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static HashMap<String, Date> createMap() {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", new Date("JUNE 1 1980"));
        map.put("Stallone4", new Date("JUNE 1 1980"));
        map.put("Van Damm", new Date("JUNE 2 1980"));
        map.put("Stallone2", new Date("JULY 4 1983"));
        map.put("Stallone3", new Date("AUGUST 4 1983"));
        map.put("Stallone5", new Date("SEPTEMBER 4 1983"));
        map.put("Stallone6", new Date("NOVEMBER 4 1983"));
        map.put("Stallone7", new Date("DECEMBER 4 1983"));
        map.put("Stallone8", new Date("MARCH 4 1983"));
        map.put("Stallone9", new Date("JUNE 4 1983"));

        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map) {
        for( Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator(); iterator.hasNext();){
            Map.Entry<String, Date> entry = iterator.next();
            Date date = entry.getValue();
            if(date.getMonth()> 4 && date.getMonth() < 8) iterator.remove();
        }
    }

    public static void main(String[] args) {
//    HashMap<String, Date> map = createMap();
//    removeAllSummerPeople(map);
    }
}
