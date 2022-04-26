package com.bkitsolution;

import java.util.HashMap;
import java.util.Map;

public class Catalogue {
//    private static Map<String, Product> productMap = Map.of(
//            "Electric Toothbrush", new Product("Electric Toothbrush", 3550),
//            "Baby Alarm", new Product("Baby Alarm", 4999)
//    );

    private static Map<String, Product> productMap = new HashMap<>();

    static {
        productMap.put("Electric Toothbrush", new Product("Electric Toothbrush", 3550));
        productMap.put("Baby Alarm", new Product("Baby Alarm", 4999));
    }

    public static Product getProduct(String productName) {
        return productMap.get(productName);
    }
}
