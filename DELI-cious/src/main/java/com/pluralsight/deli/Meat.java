package com.pluralsight.deli;

public class Meat extends PremiumTopping {
    private MeatType meatType;  // Type of meat, e.g., Turkey, Ham, etc.

    // Constructor that initializes the meat type and the extra multiplier
    public Meat(MeatType meatType) {
        super(meatType.toString());  // Initialize name from enum and multiplier
        this.meatType = meatType;
    }

    @Override
    public double getPrice(BreadSize breadSize) {
        // Set the base price for the meat depending on the bread size
        double basePrice = 0.0;
        double extraPrice = 0.0;

        // Example pricing logic for different bread sizes
        switch (breadSize) {
            case FOUR_INCH: basePrice = 5.50; extraPrice = .50; break;
            case EIGHT_INCH: basePrice = 7.50; extraPrice = 1.00; break;
            case FOOTLONG: basePrice = 8.50; extraPrice = 1.50; break;
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
