package ru.job4j.oop.casting;

public class Plane implements  Vehicle {
    @Override
    public void move() {
        System.out.println("Летает по воздуху.");
    }
}
