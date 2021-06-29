package ru.job4j.oop.casting;

public class Train implements Vehicle {
    @Override
    public void move() {
        System.out.println("Передвигается по рельсам.");
    }
}
