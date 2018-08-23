package com.javarush.task.task21.task2109;

/* 
Запретить клонирование
*/
public class Solution {
    public static void main(String[] args) throws CloneNotSupportedException {
        A a = new A(5, 6);
        A clone_a = a.clone();

        B b = new B(7, 8, "class B");
        B clone_b = b.clone();

        C c = new C(3, 20, "class C");
        C clone_c = c.clone();
    }

    public static class A implements Cloneable {
        private int i;
        private int j;

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }

        @Override
        public A clone() throws CloneNotSupportedException {
            return (A) super.clone();
        }
    }

    public static class B extends A {
        private String name;

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public B clone() throws CloneNotSupportedException {
            throw new CloneNotSupportedException();
        }
    }

    public static class C extends B {
        public C(int i, int j, String name) {
            super(i, j, name);
        }

        @Override
        public C clone() throws CloneNotSupportedException {
            C copy = new C(getI(), getJ(), getName());
            return copy;
        }
    }
}
