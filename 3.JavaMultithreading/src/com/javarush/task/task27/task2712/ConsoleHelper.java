package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHelper {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message){
        System.out.println(message);
    }
    public static String readString() throws IOException {
        return reader.readLine();
    }
    public static List<Dish> getAllDishesForOrder() throws IOException {
        List<Dish> selectedDishes = new ArrayList<Dish>();

        writeMessage("Выберите блюдо...");
        writeMessage(Dish.allDishesToString());

        while (true){
           String input = readString();
            if (input.equalsIgnoreCase("exit")) break;

            Dish dish = null;
            try {
                dish = Dish.valueOf(input);
            } catch (IllegalArgumentException e) {
                writeMessage(input + " - это блюдо пока не готовится. Пожалуйста, выберите блюдо из списка!");
                continue;
            }

            selectedDishes.add(dish);
        }
        return selectedDishes;
    }
}
