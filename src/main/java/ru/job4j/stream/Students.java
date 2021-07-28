package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Students {
    public static Map<String, Student> collect(List<Student> students) {
        return students.stream().collect(
                Collectors.toMap(
                        student -> student.getSurname(),
                        student -> student,
                        (student, student2) -> student2
                )
        );
    }
}
