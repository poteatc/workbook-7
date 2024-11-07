package com.pluralsight.deli;

public abstract class Topping implements Priceable {
    protected String name;

//    // Constructor that initializes name and the multiplier
    public Topping(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
