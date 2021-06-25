package ru.job4j.pojo;

public class ShopDrop {
    public static Product[] delete(Product[] products, int index) {
        while (index < products.length - 1) {
            products[index++] = products[index];
        }
        products[index] = null;
        return products;
    }
}
