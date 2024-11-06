package com.pluralsight.deli;

public interface Priceable {
    default double getPrice() {
        return 0.0;
    }
    void setPrice(double price);
}
