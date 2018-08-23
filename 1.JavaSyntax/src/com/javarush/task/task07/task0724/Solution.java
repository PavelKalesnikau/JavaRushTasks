package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

public class Solution {
    public static void main(String[] args) {

        Human grandfather1 = new Human("Алексей",true, 80);
        Human grandfather2 = new Human("Федор",true, 75);
        Human grandmother1 = new Human("Ольга",false, 79);
        Human grandmother2 = new Human("Ульяна",false, 73);

        Human father = new Human("Михаил",true, 55, grandfather1, grandmother1);
        Human mother = new Human("Анна",false, 50, grandfather2, grandmother2);

        Human child1 = new Human("Андрей",true, 30, father, mother);
        Human child2 = new Human("Надежда",false, 28, father, mother);
        Human child3 = new Human("Ира",false, 26, father, mother);

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
        Human father;
        Human mother;

        public Human(String name, boolean sex, int age ){
            this.name = name;
            this.sex = sex;
            this.age = age;
        }
        public Human(String name, boolean sex, int age, Human father, Human mother ){
            this(name, sex, age);
            this.father = father;
            this.mother = mother;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }
}






















