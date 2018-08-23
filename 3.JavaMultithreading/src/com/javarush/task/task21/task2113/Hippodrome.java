package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    public static Hippodrome game;

    private List<Horse> horses = null;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public static void main(String[] args) throws InterruptedException {
        Horse horse1 = new Horse("Horse1", 3, 0);
        Horse horse2 = new Horse("Horse2", 3, 0);
        Horse horse3 = new Horse("Horse3", 3, 0);

        List<Horse> horses = new ArrayList<Horse>();
        horses.add(horse1);
        horses.add(horse2);
        horses.add(horse3);

        game = new Hippodrome(horses);
        game.run();
        game.printWinner();
    }

    public List<Horse> getHorses() {
        return horses;
    }

    void run() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }

    void move() {
        for (Horse horse : horses) {
            horse.move();
        }
    }

    void print() {
        for (Horse horse :
                horses) {
            horse.print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public Horse getWinner() {
        double max_distance = 0;
        Horse winner = null;
        for (Horse horse :
                horses) {
            if (max_distance < horse.getDistance()) {
                max_distance = horse.getDistance();
                winner = horse;
            }
        }
        return winner;
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }
}
