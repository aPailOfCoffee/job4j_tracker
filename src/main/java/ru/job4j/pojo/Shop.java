package ru.job4j.pojo;

public class Shop {
    public static int indexOfNull(Product[] product) {
        int rsl = -1;
        for (int i = 0; i < product.length; i++) {
            if (product[i] == null) {
                rsl = i;
                break;
            }
        }
        return rsl;
    }
}
