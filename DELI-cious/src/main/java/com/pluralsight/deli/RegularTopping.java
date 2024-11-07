package com.pluralsight.deli;

public class RegularTopping extends Topping {
    private RegularToppingType regularToppingType;

    public RegularTopping(RegularToppingType regularToppingType) {
        super(regularToppingType.toString());
        this.regularToppingType = regularToppingType;
    }
}
