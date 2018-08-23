package com.javarush.task.task08.task0824;

/* 
Собираем семейство
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {

        Human child1 = new Human();
        child1.name = "Scott";
        child1.sex = true;
        child1.age = 20;

        Human child2 = new Human();
        child2.name = "Sandra";
        child2.sex = false;
        child2.age = 19;

        Human child3 = new Human();
        child3.name = "Jessica";
        child3.sex = false;
        child3.age = 15;


        Human father = new Human();
        father.name = "Richard";
        father.sex = true;
        father.age = 42;
        father.children.add(child1);
        father.children.add(child2);
        father.children.add(child3);

        Human mother = new Human();
        mother.name = "Stesi";
        mother.sex = false;
        mother.age = 38;
        mother.children.add(child1);
        mother.children.add(child2);
        mother.children.add(child3);

        Human grandfather1 = new Human();
        grandfather1.name = "John";
        grandfather1.sex = true;
        grandfather1.age = 68;
        grandfather1.children.add(father);

        Human grandfather2 = new Human();
        grandfather2.name = "Peter";
        grandfather2.sex = true;
        grandfather2.age = 65;
        grandfather2.children.add(mother);

        Human grandmother1 = new Human();
        grandmother1.name = "Ruth";
        grandmother1.sex = false;
        grandmother1.age = 66;
        grandmother1.children.add(father);

        Human grandmother2 = new Human();
        grandmother2.name = "Lilu";
        grandmother2.sex = false;
        grandmother2.age = 62;
        grandmother2.children.add(mother);

        System.out.println(grandfather1);
        System.out.println(grandfather2);
        System.out.println(grandmother1);
        System.out.println(grandmother2);
        System.out.println(father);
        System.out.println(mother);
        System.out.println(child1);
        System.out.println(child2);
        System.out.println(child3);

    }

    public static class Human {
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children = new ArrayList<Human>();

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }

}
