package ru.job4j.tracker;

import org.junit.Test;
import java.util.*;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class ItemTest {
    @Test
    public void whenSortByNameAscend() {
        List<Item> items = new ArrayList<>(Arrays.asList(
                new Item(2, "BBB"),
                new Item(1, "AAA"),
                new Item(3, "CCC")
                )
        );
        List<Item> expect = new ArrayList<>(Arrays.asList(
                new Item(1, "AAA"),
                new Item(2, "BBB"),
                new Item(3, "CCC")
            )
        );
        Collections.sort(items, new SortByNameAscend());
        assertThat(items, is(expect));
    }

    @Test
    public void whenSortByNameDescend() {
        List<Item> items = new ArrayList<>(Arrays.asList(
                new Item(2, "BBB"),
                new Item(1, "AAA"),
                new Item(3, "CCC")
        )
        );
        List<Item> expect = new ArrayList<>(Arrays.asList(
                new Item(3, "CCC"),
                new Item(2, "BBB"),
                new Item(1, "AAA")
        )
        );
        Collections.sort(items, new SortByNameDescend());
        assertThat(items, is(expect));
    }

    @Test
    public void whenSortByIdAscend() {
        List<Item> items = new ArrayList<>(Arrays.asList(
                new Item(2, "AAA"),
                new Item(1, "AAA"),
                new Item(3, "AAA")
        )
        );
        List<Item> expect = new ArrayList<>(Arrays.asList(
                new Item(1, "AAA"),
                new Item(2, "AAA"),
                new Item(3, "AAA")
        )
        );
        Collections.sort(items);
        assertThat(items, is(expect));
    }

    @Test
    public void whenSortByIdDescend() {
        List<Item> items = new ArrayList<>(Arrays.asList(
                new Item(2, "AAA"),
                new Item(1, "AAA"),
                new Item(3, "AAA")
        )
        );
        List<Item> expect = new ArrayList<>(Arrays.asList(
                new Item(3, "AAA"),
                new Item(2, "AAA"),
                new Item(1, "AAA")
        )
        );
        Collections.sort(items, Collections.reverseOrder());
        assertThat(items, is(expect));
    }
}