package ru.job4j.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MatrixTest {

    @Test
    public void whenMatrixThenList() {
        Integer[][] matrix = {
                {1, 2},
                {3, 4},
                {5, 6}
        };
        List<Integer> expect = Arrays.asList(
                1, 2, 3, 4, 5, 6
        );
        assertThat(Matrix.matrixToList(matrix), is(expect));
    }
}