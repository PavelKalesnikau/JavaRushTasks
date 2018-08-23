package com.javarush.task.task08.task0802;

/* 
HashMap из 10 пар
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws Exception {
//        арбуз — ягода,
//        банан — трава,
//        вишня — ягода,
//        груша — фрукт,
//        дыня — овощ,
//        ежевика — куст,
//        жень-шень — корень,
//        земляника — ягода,
//        ирис — цветок,
//        картофель — клубень.

        HashMap<String, String> map = new HashMap<String,String>();
        map.put("арбуз", "ягода");
        map.put("банан", "трава");
        map.put("вишня", "ягода");
        map.put("груша", "фрукт");
        map.put("дыня", "овощ");
        map.put("ежевика", "куст");
        map.put("жень-шень", "корень");
        map.put("земляника", "ягода");
        map.put("ирис", "цветок");
        map.put("картофель", "клубень");

        for (Map.Entry<String, String> entry: map.entrySet() ) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + " - " + value);
        }

    }
}
