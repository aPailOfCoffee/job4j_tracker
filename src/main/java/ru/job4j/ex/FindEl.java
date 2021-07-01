package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int index = 0; index < value.length; index++) {
            if (value[index].equals(key)) {
                rsl = index;
            }
        }
        if (rsl == -1) {
            throw new ElementNotFoundException("The key word is missing");
        }
        return rsl;
    }

    public static void main(String[] args) {
        try {
            String[] array = {"one", "two", "three", "four"};
            indexOf(array, "nine");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
