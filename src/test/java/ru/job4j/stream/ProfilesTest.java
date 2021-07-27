package ru.job4j.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ProfilesTest {

    @Test
    public void collect() {
        List<Address> addresses = Arrays.asList(
                new Address("Magadan", "Lenina str.", 1, 1),
                new Address("Omsk", "Kirova str.", 10, 10),
                new Address("Pskov", "Traktornaya str.", 2, 999)
        );
        List<Profile> profiles = addresses.stream()
                .map(address -> new Profile(address))
                .collect(Collectors.toList());
        assertThat(Profiles.collect(profiles), is(addresses));
    }
}