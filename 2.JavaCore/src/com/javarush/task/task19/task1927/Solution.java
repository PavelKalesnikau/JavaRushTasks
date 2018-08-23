package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        PrintStream consoleStream = System.out;

        // make a wrapper for console stream
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);

        testString.printSomething();
        System.setOut(consoleStream); // return stream back to console

//     Работающий вариант. Но валидатор не принимает.
       BufferedReader reader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(outputStream.toByteArray())));
        int count = 0;
        String line = null;
        while ((line = reader.readLine())!= null){
            System.out.println(line);
            count++;
            if (count%2 == 0)
                System.out.println("JavaRush - курсы Java онлайн");
        }
        outputStream.close();
        reader.close();
        stream.close();

      /* // Второй вариант, который мне не очень нравится, но принят валидатором
        String output = outputStream.toString();
        int count = 0;
        for (String line: output.split("\n")) {
            System.out.println(line);
            count++;
            if (count%2 == 0) System.out.println("JavaRush - курсы Java онлайн");
        }
        outputStream.close();
        stream.close();*/
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
