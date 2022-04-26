package com.bkitsolution;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Product> products = new ArrayList<>();

    public ShoppingCart() {

    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public int getTotalCost() {
        return products.stream()
                .mapToInt(Product::getPrice)
                .sum();
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "products=" + products +
                '}';
    }

}
