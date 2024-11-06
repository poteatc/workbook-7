package com.pluralsight.deli;

public class Cheese extends PremiumTopping {
    private CheeseType cheeseType;

    // Constructor that initializes the meat type and the extra multiplier
    public Cheese(CheeseType cheeseType) {
        super(cheeseType.toString());  // Initialize name from enum and multiplier
        this.cheeseType = cheeseType;
    }

    @Override
    public double getPrice(BreadSize breadSize) {
        // Set the base price for the cheese depending on the bread size
        double basePrice = 0.0;
        double extraPrice = 0.0;

        // Example pricing logic for different bread sizes
        switch (breadSize) {
            case FOUR_INCH: basePrice = .75; extraPrice = .30; break;
            case EIGHT_INCH: basePrice = 1.50; extraPrice = .60; break;
            case FOOTLONG: basePrice = 2.25; extraPrice = .90; break;
            default: basePrice = 0.0; extraPrice = 0.0; break;
        }

        return basePrice + extraPrice;
    }

    @Override
    public double getPrice() {
        // Default getPrice method from Priceable interface (not used if getPrice(BreadSize) is more appropriate)
        // Optionally, you could call the other getPrice() method here if needed
        return getPrice(BreadSize.FOOTLONG);  // Default to FOOTLONG if bread size is not provided
    }
}
