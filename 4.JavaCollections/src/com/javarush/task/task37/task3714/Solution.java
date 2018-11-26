package com.javarush.task.task37.task3714;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Древний Рим
*/
public class Solution {
    public static void main(String[] args) throws IOException {
/*
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input a roman number to be converted to decimal: ");
        String romanString = bufferedReader.readLine();
        System.out.println("Conversion result equals " + romanToInteger(romanString));
*/
        System.out.println("Conversion result equals " + romanToInteger("XCIV")); // 94
        System.out.println("Conversion result equals " + romanToInteger("MCMLXXXVIII")); // 1988
        System.out.println("Conversion result equals " + romanToInteger("MMMCMXCIX")); // 3999

        System.out.println("Conversion result equals " + romanToInteger("MMDCLXXXIII")); // 2683
        System.out.println("Conversion result equals " + romanToInteger("MCMXCIX")); // 1999
    }

    public static int romanToInteger(String s) {
        int nArabic = 0;
        int i = 0;
        while (i < s.length()) {
            ROMAN roman = ROMAN.valueOf(String.valueOf(s.charAt(i)));
            int cArabicCur = getArabic(roman);

            int cArabicPrev = -1;
            if (i > 0) {
                roman = ROMAN.valueOf(String.valueOf(s.charAt(i - 1)));
                cArabicPrev = getArabic(roman);
            }

            int cArabicFwd = -1;
            if (i < s.length() - 1) {
                roman = ROMAN.valueOf(String.valueOf(s.charAt(i + 1)));
                cArabicFwd = getArabic(roman);
            }

            if (cArabicCur < cArabicFwd && cArabicFwd != -1) {
                nArabic += cArabicFwd - cArabicCur;
                i += 2;
            } else if (cArabicCur <= cArabicPrev || cArabicPrev == -1) {
                nArabic += cArabicCur;
                i++;
            }

        }
        return nArabic;
    }

    private static int getArabic(ROMAN roman) {
        switch (roman) {
            case I:
                return 1;
            case V:
                return 5;
            case X:
                return 10;
            case L:
                return 50;
            case C:
                return 100;
            case D:
                return 500;
            case M:
                return 1000;
        }
        return 0;
    }

    public enum ROMAN {
        I, // 1
        V, // 5
        X, // 10
        L, // 50
        C, // 100
        D, // 500
        M;  // 1000
    }
}
