package com.pluralsight.deli.gui;

import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {
    public MenuPanel() {
        setLayout(new GridLayout(0, 1)); // One column layout

        // Example menu items for a deli
        JButton sandwichButton = new JButton("Sandwich - $5.00");
        JButton drinkButton = new JButton("Drink - $2.00");
        JButton saladButton = new JButton("Salad - $4.00");

        // Add action listeners for adding items
        sandwichButton.addActionListener(e -> addItem("Sandwich", 5.00));
        drinkButton.addActionListener(e -> addItem("Drink", 2.00));
        saladButton.addActionListener(e -> addItem("Salad", 4.00));

        // Add buttons to the panel
        add(sandwichButton);
        add(drinkButton);
        add(saladButton);
    }

    private void addItem(String itemName, double price) {
        // Logic to add item to the order panel
        System.out.println("Added " + itemName + " to the order.");
        OrderPanel.addOrderItem(itemName, price);
    }
}
