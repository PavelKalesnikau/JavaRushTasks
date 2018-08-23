package com.javarush.task.task25.task2502;

import java.util.ArrayList;
import java.util.List;

/* 
Машину на СТО не повезем!
*/
public class Solution {
    public static void main(String[] args) {
    Car car = new Car();
    }

    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() throws IllegalArgumentException {
            //init wheels here
            String[] wheelsFromDB = loadWheelNamesFromDB();
            if (wheelsFromDB.length != 4) throw new IllegalArgumentException();
            wheels = new ArrayList<Wheel>(wheelsFromDB.length);
            for (String wheel : wheelsFromDB) {
                wheels.add(Wheel.valueOf(wheel));
            }
        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
    }
}
