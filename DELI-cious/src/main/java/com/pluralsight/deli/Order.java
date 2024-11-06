package com.pluralsight.deli;

import java.util.ArrayList;
import java.util.List;

public class Order implements Priceable {
    List<Product> products;

    public Order() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    @Override
    public double getPrice() {
        return 0;
    }

    @Override
    public void setPrice(double price) {

    }
}
