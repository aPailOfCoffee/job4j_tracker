package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        Predicate<Person> inName = person -> person.getName().contains(key);
        Predicate<Person> inSurname = person -> person.getSurname().contains(key);
        Predicate<Person> inPhone = person -> person.getPhone().contains(key);
        Predicate<Person> inAddress = person -> person.getAddress().contains(key);
        var combine = inName.or(inSurname).or(inPhone).or(inAddress);
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
