package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /*public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (
                    person.getName().contains(key)
                    || person.getSurname().contains(key)
                    || person.getPhone().contains(key)
                    || person.getAddress().contains(key)
            ) {
                result.add(person);
            }
        }
        return result;
    }*/

    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        Predicate<Person> inName = person -> person.getName().contains(key);
        Predicate<Person> inSurname = person -> person.getSurname().contains(key);
        Predicate<Person> inPhone = person -> person.getPhone().contains(key);
        Predicate<Person> inAddress = person -> person.getAddress().contains(key);
        Predicate<Person> combine = inName.or(inSurname).or(inPhone).or(inAddress);
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
