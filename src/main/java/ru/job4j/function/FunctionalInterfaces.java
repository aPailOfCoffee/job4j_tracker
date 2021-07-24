package ru.job4j.function;

import java.util.*;
import java.util.function.*;

public class FunctionalInterfaces {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        BiConsumer<Integer, String> bicon = (key, value) -> map.put(key, value);
        bicon.accept(1, "one");
        bicon.accept(2, "two");
        bicon.accept(3, "three");
        bicon.accept(4, "four");
        bicon.accept(5, "five");
        bicon.accept(6, "six");
        bicon.accept(7, "seven");

        BiPredicate<Integer, String> biPred = (i, s) -> i % 2 == 0 && s.length() == 4;
        for (Integer i : map.keySet()) {
            if (biPred.test(i, map.get(i))) {
                System.out.println("key: " + i + " value: " + map.get(i));
            }
        }

        Supplier<List<String>> sup = () -> new ArrayList<>(map.values());
        List<String> strings = sup.get();

        Consumer<String> con = (s) -> System.out.println(s);
        Function<String, String> func = (s) -> s.toUpperCase();
        for (String s : strings) {
            con.accept(func.apply(s));
        }
    }
}
