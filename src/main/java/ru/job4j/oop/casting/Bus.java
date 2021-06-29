package ru.job4j.oop.casting;

public class Bus implements Vehicle {
    @Override
    public void move() {
        System.out.println("Двигается по скоростным трассам.");
    }
}
