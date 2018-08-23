package com.javarush.task.task30.task3001;

import java.math.BigInteger;

/*
Конвертер систем счислений
*/
public class Solution {
    public static void main(String[] args) {
        Number number = new Number(NumerationSystemType._10, "6");
        Number result = convertNumberToOtherNumerationSystem(number, NumerationSystemType._2);
        System.out.println(result);    //expected 110

        number = new Number(NumerationSystemType._16, "6df");
        result = convertNumberToOtherNumerationSystem(number, NumerationSystemType._8);
        System.out.println(result);    //expected 3337

        number = new Number(NumerationSystemType._2, "120");
        result = convertNumberToOtherNumerationSystem(number, NumerationSystemType._8);
        System.out.println(result);    //expected 3337

    }

    public static Number convertNumberToOtherNumerationSystem(Number number, NumerationSystem expectedNumerationSystem)
    throws NumberFormatException{
        //напишите тут ваш код
        String s = number.getDigit();
        NumerationSystem ns = number.getNumerationSystem();
        int or_ns = ns.getNumerationSystemIntValue();
        BigInteger bigInteger = new BigInteger(s, or_ns);
        String new_n = bigInteger.toString(expectedNumerationSystem.getNumerationSystemIntValue());
        Number new_number = new Number(expectedNumerationSystem, new_n);

        return new_number;
    }
}
