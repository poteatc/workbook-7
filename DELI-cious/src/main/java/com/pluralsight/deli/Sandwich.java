package com.pluralsight.deli;

import java.util.ArrayList;
import java.util.List;

public class Sandwich extends Product {
    private List<Topping> toppings;
    private Bread bread;

    public Sandwich(Bread bread) {
        this.toppings = new ArrayList<>();
        this.bread = bread;
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    @Override
    public double getPrice() {
        return super.getPrice();
    }

    @Override
    public void setPrice(double price) {

    }
}
