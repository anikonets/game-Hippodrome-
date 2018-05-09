package com.company;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {

    private List<Horse> horses;
    static Hippodrome game;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public static void main(String[] args) {
        game = new Hippodrome(new ArrayList<>());
        Horse roel = new Horse("Roel", 3, 0);
        game.getHorses().add(roel);
        Horse kapel = new Horse("Kapel", 3, 0);
        game.getHorses().add(kapel);
        Horse egida = new Horse("Egida", 3, 0);
        game.getHorses().add(egida);
        Horse lucky = new Horse("Lucky", 3, 0);
        game.getHorses().add(lucky);
        game.run();
        game.printWinner();
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void move() {
        for (Horse horse : horses) {
            horse.move();
        }
    }

    public void print() {
        for (Horse horse : horses) {
            horse.print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public Horse getWinner() {
        Horse winner = horses.get(0);
        for (Horse horse : horses) {
            if (horse.distance > winner.distance) {
                winner = horse;
            }
        }
        return winner;
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().name + "!");
    }
}