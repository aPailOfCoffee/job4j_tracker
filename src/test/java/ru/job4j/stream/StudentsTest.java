package ru.job4j.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StudentsTest {

    @Test
    public void whenCollect() {
        List<Student> students = Arrays.asList(
                new Student(10, "Ivanov"),
                new Student(90, "Petrov"),
                new Student(80, "Kim")
        );
        Map<String, Student> expect = new HashMap<>();
        expect.put("Ivanov", new Student(10, "Ivanov"));
        expect.put("Petrov", new Student(90, "Petrov"));
        expect.put("Kim", new Student(80, "Kim"));
        assertThat(Students.collect(students), is(expect));
    }

    @Test
    public void whenCollectWithDuplicates() {
        List<Student> students = Arrays.asList(
                new Student(10, "Ivanov"),
                new Student(10, "Ivanov"),
                new Student(90, "Petrov"),
                new Student(80, "Kim"),
                new Student(90, "Kim")
        );
        Map<String, Student> expect = new HashMap<>();
        expect.put("Ivanov", new Student(10, "Ivanov"));
        expect.put("Petrov", new Student(90, "Petrov"));
        expect.put("Kim", new Student(90, "Kim"));
        assertThat(Students.collect(students), is(expect));
    }
}