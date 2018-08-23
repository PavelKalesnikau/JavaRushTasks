package com.javarush.task.task09.task0912;

/* 
Исключение при работе с числами
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код

        try {
            int num = Integer.parseInt("XYZ");
            System.out.println(num);
        } catch (NumberFormatException e) {
            System.out.println(e);

            if (e instanceof NumberFormatException)
                System.out.println("Возникло исключение NumberFormatException ");
        }

        //напишите тут ваш код
    }
}
