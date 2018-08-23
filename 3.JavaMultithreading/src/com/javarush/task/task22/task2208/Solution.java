package com.javarush.task.task22.task2208;

import java.util.Map;
import java.util.TreeMap;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {
        /*Map params = new TreeMap<String, String>();
        params.put("name", "Ivanov");
        params.put("country", "Ukraine");
        params.put("city", "Kiev");
        params.put("age", null);
        System.out.println(getQuery(params));*/
    }
    public static String getQuery(Map<String, String> params) {
        StringBuilder query = new StringBuilder();
        int size = params.size();
        int i = 0;
        for (Map.Entry<String, String> entry : params.entrySet()) {
            i++;
            if (entry.getValue() != null){
                query.append(entry.getKey()).append(" = ").append("'").append(entry.getValue()).append("'");
                        if (i < size) query.append(" and ");
            }
        }

        return query.toString();
    }
}
