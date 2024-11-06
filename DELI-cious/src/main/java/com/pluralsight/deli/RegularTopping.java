package com.pluralsight.deli;

public class RegularTopping extends Topping {
    private RegularToppingType regularToppingType;

    public RegularTopping(RegularToppingType regularToppingType) {
        super(regularToppingType.toString());
        this.regularToppingType = regularToppingType;
    }

    // No need to override getPrice() since it defaults to 0 in the Priceable interface

    @Override
    public void setPrice(double price) {

    }
}
