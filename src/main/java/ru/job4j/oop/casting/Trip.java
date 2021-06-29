package ru.job4j.oop.casting;

public class Trip {
    public static void main(String[] args) {
        Vehicle train1 = new Train();
        Vehicle train2 = new Train();
        Vehicle plane1 = new Plane();
        Vehicle plane2 = new Plane();
        Vehicle bus1 = new Bus();
        Vehicle bus2 = new Bus();
        Vehicle[] transport = new Vehicle[] {train1, train2, plane1, plane2, bus1, bus2};
        for (Vehicle a : transport) {
            a.move();
        }
    }
}
