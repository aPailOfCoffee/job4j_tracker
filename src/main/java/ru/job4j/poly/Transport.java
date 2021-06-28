package ru.job4j.poly;

public interface Transport {
    void drive();

    void passengers(int passengerCount);

    double fill(double gasoline);
}
