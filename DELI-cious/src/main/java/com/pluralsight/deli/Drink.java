package com.pluralsight.deli;

public class Drink extends Product {
    private DrinkSize drinkSize;
    private DrinkType drinkType;

    public Drink(DrinkSize drinkSize, DrinkType drinkType) {
        this.drinkSize = drinkSize;
        this.drinkType = drinkType;
    }

    @Override
    public double getPrice() {
        return super.getPrice();
    }
}
