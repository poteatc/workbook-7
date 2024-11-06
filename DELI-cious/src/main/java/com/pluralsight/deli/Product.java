package com.pluralsight.deli;


/*
An abstract class, on the other hand, can implement an interface without providing implementations for all (or any)
of its methods. This is because an abstract class itself cannot be instantiated,
 so it doesn’t need to fulfill the interface’s contract completely. Instead, it can leave the
 implementation details to its subclasses.
 */
public abstract class Product implements Priceable {
    protected double price;

    public Product(double price) {
        this.price = price;
    }

}
