package com.pluralsight.deli;

public abstract class PremiumTopping extends Topping {

    // Constructor that initializes the name of the topping
    public PremiumTopping(String name) {
        super(name);  // Pass name to the superclass Topping
    }

    // Abstract method for calculating price based on bread size
    public abstract double getPrice(BreadSize breadSize);
}
