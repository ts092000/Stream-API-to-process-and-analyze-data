package com.bkitsolution;

public class Product {
    private final String name;
    private int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "\n" + "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                "}";
    }
}
