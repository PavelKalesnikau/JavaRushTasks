package com.javarush.task.task06.task0601;

/* 
Метод finalize класса Cat
*/

public class Cat {

    public static void main(String[] args) {

    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}
