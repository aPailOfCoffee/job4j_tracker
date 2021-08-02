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
                new Student("Ivanov", 10),
                new Student("Petrov", 90),
                new Student("Kim", 80)
        );
        Map<String, Student> expect = new HashMap<>();
        expect.put("Ivanov", new Student("Ivanov", 10));
        expect.put("Petrov", new Student("Petrov", 90));
        expect.put("Kim", new Student("Kim", 80));
        assertThat(Students.collect(students), is(expect));
    }

    @Test
    public void whenCollectWithDuplicates() {
        List<Student> students = Arrays.asList(
                new Student("Ivanov", 10),
                new Student("Ivanov", 10),
                new Student("Petrov", 90),
                new Student("Kim", 80),
                new Student("Kim", 90)
        );
        Map<String, Student> expect = new HashMap<>();
        expect.put("Ivanov", new Student("Ivanov", 10));
        expect.put("Petrov", new Student("Petrov", 90));
        expect.put("Kim", new Student("Kim", 90));
        assertThat(Students.collect(students), is(expect));
    }
}