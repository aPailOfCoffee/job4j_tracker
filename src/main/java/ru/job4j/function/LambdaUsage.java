package ru.job4j.function;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LambdaUsage {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("aaa");
        strings.add("bbbbbb");
        strings.add("aa");
        strings.add("aaaaaaaaa");

        Comparator<String> cmpDescSize = (left, right) -> {
            System.out.println("compare: " + right.length() + " vs " + left.length());
            return Integer.compare(right.length(), left.length());
        };
        strings.sort(cmpDescSize);
        System.out.println(strings);
    }
}
