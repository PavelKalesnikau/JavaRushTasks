package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);

        testString.printSomething();

        String expression = outputStream.toString();
        String[] members = expression.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < members.length-1; i++) {
            sb.append(members[i]+" ");
        }

        long result = 0;
        int number1 = Integer.valueOf(members[0]);
        int number2 = Integer.valueOf(members[2]);
        switch (members[1]){
            case "+":
                result = number1 + number2;
                break;
            case "-":
                result = number1 - number2;
                break;
            case "*":
                result = number1 * number2;
                break;
        }

        System.setOut(consoleStream);

        sb.append(result);
        System.out.println(sb.toString());

/*
//      Этот вариант тоже рабочий, но не прошел валидатор

        int number1 = Character.getNumericValue(outputStream.toString().charAt(0));
        int number2 = Character.getNumericValue(outputStream.toString().charAt(4));
        char sign = outputStream.toString().charAt(2);

        //       if (sign == '+') result = number1 + number2;
//       else if (sign == '-') result = number1 + number2;
//       else if (sign == '*') result = number1 * number2;
        switch (sign){
            case '+':
                result = number1 + number2;
                break;
            case '-':
                result = number1 - number2;
                break;
            case '*':
                result = number1 * number2;
                break;
        }
        System.setOut(consoleStream);

        System.out.print(outputStream.toString().replaceAll("[\\n\\r]", "")+result);
*/

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }

    private static boolean isNumber (String word){
        try {
            double d = Double.parseDouble(word);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}

