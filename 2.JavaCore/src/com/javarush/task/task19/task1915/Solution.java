package com.javarush.task.task19.task1915;

/* 
Дублируем текст
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
       // Читаем имя файла с консоли
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        PrintStream consoleStream = System.out; // сохраняем поток консоли
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream); // переопределяем поток консоли своей "оберткой"

        testString.printSomething(); // выводим строку в "обертку" консоли

        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        fileOutputStream.write(outputStream.toByteArray());                 // Пишем в файл из "обёртки" консоли

        System.setOut(consoleStream); // восстанавливаем поток консоли

        // также выводим в восстановленную консоль
        System.out.println(outputStream.toString());

        // закрываем потоки
        outputStream.close();
        stream.close();
        fileOutputStream.close();
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

