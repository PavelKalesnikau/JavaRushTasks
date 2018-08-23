package com.javarush.task.task30.task3010;

/* 
Минимальное допустимое основание системы счисления
*/

import java.math.BigInteger;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        try {
            if (args.length == 0) return;
            int minRadix = getNumberWithMinRadix(args[0]);
            System.out.println(minRadix == 0 ? "incorrect" : minRadix);
        } catch (Exception e) {
            return;
        }
    }

    private static int getNumberWithMinRadix(String string) {
        for (int radix = 2; radix < 37; radix++) {
            try {
                BigInteger bigInteger = new BigInteger(string, radix);
                return radix;
            } catch (Exception e) {
                continue;
            }
        }
        return 0;
    }
}