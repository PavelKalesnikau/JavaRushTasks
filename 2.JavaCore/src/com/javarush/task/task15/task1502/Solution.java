package com.javarush.task.task15.task1502;

/* 
ООП - Наследование животных
*/

public class Solution {
    Goose goose = new Goose();
    Dragon dragon = new Dragon();
//    static BigAnimal animal = new BigAnimal();

    public static void main(String[] args) {
//        String s = animal.getSize();
//        System.out.println(s);
    }

    public static class BigAnimal {
        protected String getSize() {
            return "как динозавр";
        }
    }

    public static class SmallAnimal {
        String getSize() {
            return "как кошка";
        }
    }

    public static class Goose extends  SmallAnimal{
        @Override
        public String getSize() {
            return "Гусь маленький, " + super.getSize();
        }
    }

    public static class Dragon extends BigAnimal{
        @Override
        public String getSize() {
            return "Дракон большой, " + super.getSize();
        }
    }
}
