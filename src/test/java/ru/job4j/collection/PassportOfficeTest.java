package ru.job4j.collection;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
public class PassportOfficeTest {

    @Test
    public void whenAdd() {
        Citizen citizen = new Citizen("321123", "Nick Smith");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.get(citizen.getPassport()), is(citizen));
    }

    @Test
    public void whenAddDuplicate() {
        Citizen citizen = new Citizen("321123", "Nick Smith");
        Citizen duplicate = new Citizen("321123", "Nick Smith");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertFalse(office.add(duplicate));
    }
}