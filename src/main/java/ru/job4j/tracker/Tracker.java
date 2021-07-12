package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tracker {
//    private final Item[] items = new Item[100];
    private List<Item> items = new ArrayList<>();
    private int ids = 1;
    private int size = 0;

    private int indexOf(int id) {
        int rsl = -1;
        /*for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }*/
        for (Item item : items) {
            if (item.getId() == id) {
                rsl = items.indexOf(item);
                break;
            }
        }
        return rsl;
    }

    public Item add(Item item) {
        item.setId(ids++);
        //items[size++] = item;
        items.add(item);
        return item;
    }

    /*public Item[] findAll() {
        return Arrays.copyOf(items, size);
    }*/
    public List<Item> findAll() {
        return items;
    }

    /*public Item[] findByName(String key) {
        Item[] rsl = new Item[size];
        int count = 0;
        for (int index = 0; index < size; index++) {
            if (key.equals(items[index].getName())) {
                rsl[count++] = items[index];
            }
        }
        return Arrays.copyOf(rsl, count);
    }*/
    public List<Item> findByName(String key) {
        List<Item> rsl = new ArrayList<>();
        for (Item item : items) {
            if (item.getName().equals(key)) {
                rsl.add(item);
            }
        }
        return rsl;
    }

    public Item findById(int id) {
       /* int index = indexOf(id);
        return index != -1 ? items[index] : null;*/
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
        /*Item rsl = null;
        for (Item item : items) {
            if (item.getId() == id) {
                rsl = item;
            }
        }
        return rsl;*/
    }

    public boolean replace(int id, Item item) {
        /*int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            item.setId(id);
            items[index] = item;
        }
        return rsl;*/
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            item.setId(id);
            items.set(index, item);
        }
        return rsl;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            items.remove(index);
        }
        return rsl;
    }
}