package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void drive() {
        System.out.println("Go");
    }

    @Override
    public void passengers(int passengerCount) {
        System.out.println("Number of passengers: " + passengerCount);
    }

    @Override
    public double fill(double gasoline) {
        double literPrice = 54.5;
        return literPrice * gasoline;
    }
}
