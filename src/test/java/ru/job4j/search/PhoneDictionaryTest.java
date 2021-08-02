package ru.job4j.search;

import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.Matchers.empty;

public class PhoneDictionaryTest {

    @Test
    public void whenFindByName() {
        var dictionary = new PhoneDictionary();
        dictionary.add(
                new Person("Ivan", "Ivanov", "23506", "Yalta")
        );
        var result = dictionary.find("Ivan");
        assertThat(result.get(0).getName(), is("Ivan"));
    }

    @Test
    public void whenFindThenEmpty() {
        var dictionary = new PhoneDictionary();
        dictionary.add(new Person("Ivan", "Ivanov", "23506", "Yalta"));
        var result = dictionary.find("Tom");
        assertThat(result, is(empty()));
    }
}