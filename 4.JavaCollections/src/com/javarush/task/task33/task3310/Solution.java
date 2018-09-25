package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.HashMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.StorageStrategy;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        new Solution().testStrategy(new HashMapStorageStrategy(), 10000);
    }

    public static Set<Long> getIds(Shortener shortener, Set<String> strings) {
        Set<Long> keys = new HashSet<>(strings.size());
        for (String string : strings) {
            keys.add(shortener.getId(string));
        }
        return keys;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys) {
        Set<String> strings = new HashSet<>(keys.size());
        for (Long key : keys) {
            strings.add(shortener.getString(key));
        }
        return strings;
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber) {
        Helper.printMessage(strategy.getClass().getSimpleName());

        Set<String> strings = new HashSet<>();
        for (long i = 0; i < elementsNumber; i++) {
            String string = Helper.generateRandomString();
            strings.add(string);
        }
        Shortener shortener = new Shortener(strategy);

        Date startTime1 = new Date();
        Set<Long> keys = getIds(shortener, strings);
        Date endTime1 = new Date();
        System.out.println(String.valueOf(endTime1.getTime() - startTime1.getTime()));

        Date startTime2 = new Date();
        Set<String> strings_copy = getStrings(shortener, keys);
        Date endTime2 = new Date();
        System.out.println(String.valueOf(endTime2.getTime() - startTime2.getTime()));

        if (strings.size() == strings_copy.size()) Helper.printMessage("Тест пройден.");
        else Helper.printMessage("Тест не пройден.");

    }

}
