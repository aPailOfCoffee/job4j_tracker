package ru.job4j.lambda;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FunctionCalcTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = FunctionCalc.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expect = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expect));
    }

    @Test
    public void whenSquareFunctionThenSquareResults() {
        List<Double> result = FunctionCalc.diapason(1, 4, x -> x * x);
        List<Double> expect = Arrays.asList(1D, 4D, 9D);
        assertThat(result, is(expect));
    }

    @Test
    public void whenExponentialFunctionThenExponentialResults() {
        List<Double> result = FunctionCalc.diapason(1, 4, x -> Math.pow(3, x));
        List<Double> expect = Arrays.asList(3D, 9D, 27D);
        assertThat(result, is(expect));
    }
}