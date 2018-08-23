package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.ArrayList;

public class TestOrder extends Order {

    public TestOrder(Tablet tablet) throws IOException {
        super(tablet);
    }

    @Override
    protected void initDishes() throws IOException {
        dishes = new ArrayList<Dish>();
        for (int i = 0; i < 10; i++) {
            int iDish = (int)( Math.random() * Dish.values().length );
            Dish dish = Dish.values()[iDish];
            dishes.add(dish);
        }
    }
}
