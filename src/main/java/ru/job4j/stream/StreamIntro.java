package ru.job4j.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamIntro {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(
                Arrays.asList(-2, 5, 3, -99, -1, 0)
        );
        List<Integer> positiveNumbers = numbers.stream().filter(
                number -> number > 0
        ).collect(Collectors.toList());
        positiveNumbers.forEach(System.out::println);
    }
}
