package ru.job4j.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class OrderConvertTest {

    @Test
    public void whenSingleOrder() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("3dfe", "Dress"));
        HashMap<String, Order> map = OrderConvert.process(orders);
        assertThat((map.get("3dfe")), is(new Order("3dfe", "Dress")));
    }

    @Test
    public void whenDuplicateOrder() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("3dfe", "Dress"));
        orders.add(new Order("3dfe", "Dress"));
        HashMap<String, Order> map = OrderConvert.process(orders);
        assertThat(map.size(), is(1));
    }
}