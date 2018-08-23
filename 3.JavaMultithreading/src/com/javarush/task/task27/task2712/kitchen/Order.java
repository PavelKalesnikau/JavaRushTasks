package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private final Tablet tablet;
    protected List<Dish> dishes;

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        initDishes();
    }

    @Override
    public String toString() {
        if (dishes.isEmpty()) return "";
        else {
            StringBuilder sDishes = new StringBuilder(dishes.get(0).toString());

            for (int i = 1; i < dishes.size(); i++) {
                sDishes.append(", ").append(dishes.get(i));
            }

            return String.format("Your order: [%s] of %s", sDishes.toString(), tablet);
        }
    }
    public int getTotalCookingTime(){
        int cookingTime = 0;
        for (Dish dish: dishes ) {
            cookingTime += dish.getDuration();
        }
        return cookingTime;
    }
    public boolean isEmpty(){
        return dishes.size() == 0 ? true : false;
    }

    public Tablet getTablet() {
        return tablet;
    }

    public List<Dish> getDishes() {
        return dishes;
    }
    protected void initDishes() throws IOException {
        dishes = ConsoleHelper.getAllDishesForOrder();
    }
}
