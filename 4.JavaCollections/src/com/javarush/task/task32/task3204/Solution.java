package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {

        ByteArrayOutputStream generatedPassword = new ByteArrayOutputStream();
        byte randomChar;
        int char_case,
                count = 0;
        boolean isUpperHappened = false,
                isLowerHappened = false,
                isDigitHappened = false;

        while (true) {

            if (count >= 8) break;

            if (isUpperHappened && isLowerHappened && isDigitHappened)
                isDigitHappened = isLowerHappened = isUpperHappened = false;

            char_case = (int) (Math.random() * 3);

            switch (char_case) {
                case 0: // digits
                    if (!isDigitHappened) {
                        randomChar = (byte) (48 + Math.random() * 9);
                        isDigitHappened = true;
                        count++;
                    } else {
                        continue;
                    }
                    break;
                case 1: // uppercase
                    if (!isUpperHappened) {
                        randomChar = (byte) (65 + Math.random() * 26);
                        isUpperHappened = true;
                        count++;
                    } else {
                        continue;
                    }
                    break;
                case 2: // lowercase
                    if (!isLowerHappened) {
                        randomChar = (byte) (97 + Math.random() * 26);
                        isLowerHappened = true;
                        count++;
                    } else {
                        continue;
                    }
                    break;
                default:
                    continue;
            }
            generatedPassword.write(randomChar);
        }

        return generatedPassword;
    }
}