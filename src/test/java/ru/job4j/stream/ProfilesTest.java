package ru.job4j.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ProfilesTest {

    @Test
    public void whenCollect() {
        List<Address> addresses = Arrays.asList(
                new Address("Magadan", "Lenina str.", 1, 1),
                new Address("Omsk", "Kirova str.", 10, 10),
                new Address("Pskov", "Traktornaya str.", 2, 999)
        );
        List<Profile> profiles = Arrays.asList(
                new Profile(addresses.get(0)),
                new Profile(addresses.get(1)),
                new Profile(addresses.get(2))
        );
        assertThat(Profiles.collect(profiles), is(addresses));
    }

    @Test
    public void whenCollectWithoutDuplicates() {
        List<Address> addresses = Arrays.asList(
                new Address("Magadan", "Lenina str.", 1, 1),
                new Address("Omsk", "Kirova str.", 10, 10),
                new Address("Pskov", "Traktornaya str.", 2, 999),
                new Address("Pskov", "Traktornaya str.", 2, 999)
        );
        List<Profile> profiles = Arrays.asList(
                new Profile(addresses.get(0)),
                new Profile(addresses.get(1)),
                new Profile(addresses.get(2)),
                new Profile(addresses.get(3))
        );
        assertThat(Profiles.collect(profiles), is(Arrays.asList(
                new Address("Magadan", "Lenina str.", 1, 1),
                new Address("Omsk", "Kirova str.", 10, 10),
                new Address("Pskov", "Traktornaya str.", 2, 999)
                )
        ));
    }
}