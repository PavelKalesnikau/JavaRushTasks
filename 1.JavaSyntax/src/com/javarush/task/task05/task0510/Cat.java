package com.javarush.task.task05.task0510;

/* 
Кошкоинициация
*/

public class Cat {
//   Имя,
//   Имя, вес, возраст
//— Имя, возраст (вес стандартный)
//— вес, цвет (имя, адрес и возраст неизвестны, это бездомный кот)
//— вес, цвет, адрес (чужой домашний кот)

    String name;
    int weight;
    int age;
    String color;
    String address;

    public void  initialize(String name){
        this.name = name;
        this.age = 1;
        this.weight = 5;
        this.color = "red";
    }
    public void  initialize(String name, int weight, int age){
        this.name = name;
        this.weight = weight;
        this.age = age;
        this.color = "red";
    }
    public void  initialize(String name, int age){
        this.name = name;
        this.weight = 5;
        this.age = age;
        this.color = "red";
    }
    public void  initialize(int weight, String color){
        this.weight = weight;
        this.color = color;
        this.age = 1;
    }

    public void  initialize(int weight, String color, String address){
        this.weight = weight;
        this.color = color;
        this.address = address;
        this.age = 1;
    }



    public static void main(String[] args) {

    }
}
