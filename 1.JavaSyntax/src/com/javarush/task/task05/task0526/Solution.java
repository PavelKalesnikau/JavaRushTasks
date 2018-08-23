package com.javarush.task.task05.task0526;

/* 
Мужчина и женщина
*/

public class Solution {
    public static void main(String[] args) {
        Man man1 = new Man("Max", 19, "Moscow");
        Man man2 = new Man("Din", 20, "London");
        Woman woman1 = new Woman("Lilu", 21, "Kiev");
        Woman woman2 = new Woman("Lara", 17, "Madrid");

        System.out.println(man1);
        System.out.println(man2);
        System.out.println(woman1);
        System.out.println(woman2);
    }

   public static class Man{
        String name;
        int age;
        String address;

        public Man(String name, int age, String address){
            this.name = name;
            this.age = age;
            this.address = address;
        }

       @Override
       public String toString() {
           return name + " " + age + " " + address;
       }
   }
    public static class Woman{
        String name;
        int age;
        String address;
        public Woman(String name, int age, String address){
            this.name = name;
            this.age = age;
            this.address = address;
        }
        @Override
        public String toString() {
            return name + " " + age + " " + address;
        }
    }
}
