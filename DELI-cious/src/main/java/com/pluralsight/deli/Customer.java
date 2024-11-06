package com.pluralsight.deli;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    List<Order> orders;

    public Customer() {
        orders = new ArrayList<>();
    }

    public void addOrder(Order order) {
        orders.add(order);
    }
}
