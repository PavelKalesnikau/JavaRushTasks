package com.javarush.task.task26.task2601;

import java.util.Arrays;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {
        Integer[] array;
        array = sort(new Integer[]{13, 8, 15, 5, 17});
        print(array);
        array = sort(new Integer[]{13, 12, 10, 12, 10, 14, 13, 10});
        print(array);
    }
    public static void print(Integer[] array){
 /*       for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();*/
    }

    public static Integer[] sort(Integer[] array) {
        //implement logic here
        double median = findMedian(array);
        int[]arrayMedian = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            arrayMedian[i] = Math.abs(array[i]-(int)median);
        }

//        System.out.println(median);
        for (int i = 0; i < arrayMedian.length; i++) {
            for (int j = i; j < arrayMedian.length; j++) {
                if (arrayMedian[i] > arrayMedian[j]){
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;

                    temp = arrayMedian[i];
                    arrayMedian[i] = arrayMedian[j];
                    arrayMedian[j] = temp;
                }
            }
        }
        return array;
    }

    private static double findMedian(Integer[] array) {

        int length = array.length;

        Arrays.sort(array);
        int index = length / 2;
        if (length % 2 == 0) {
            return (array[index-1] + array[index]) / 2;
        } else {
            return array[index];
        }
    }
}
