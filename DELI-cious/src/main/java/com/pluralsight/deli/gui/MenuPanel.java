package com.pluralsight.deli.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPanel extends JPanel {
    private JPanel mainMenuPanel;
    private JPanel toppingsPanel;
    private JPanel drinksPanel;
    private JPanel chipsPanel;

    // Track current drink selection
    private String selectedDrinkType = "";
    private String selectedDrinkSize = "";
    private final JLabel currentSelectionLabel = new JLabel("Selected drink: None");

    public MenuPanel() {
        setLayout(new CardLayout()); // CardLayout to switch between main and submenus

        // Initialize the main menu and submenus
        mainMenuPanel = createMainMenuPanel();
        toppingsPanel = createToppingsPanel();
        drinksPanel = createDrinksPanel();
        chipsPanel = createChipsPanel();

        // Add each panel to the CardLayout
        add(mainMenuPanel, "MainMenu");
        add(toppingsPanel, "ToppingsMenu");
        add(drinksPanel, "DrinksMenu");
        add(chipsPanel, "ChipsMenu");

        // Show the main menu initially
        showMainMenu();
    }

    // Show the main menu
    private void showMainMenu() {
        CardLayout cl = (CardLayout) getLayout();
        cl.show(this, "MainMenu");
    }

    // Show the toppings menu for the sandwich
    private void showToppingsMenu() {
        CardLayout cl = (CardLayout) getLayout();
        cl.show(this, "ToppingsMenu");
    }

    // Show the drinks menu for choosing type and size
    private void showDrinksMenu() {
        CardLayout cl = (CardLayout) getLayout();
        cl.show(this, "DrinksMenu");
    }


    // Show the chips menu for choosing chip type
    private void showChipsMenu() {
        CardLayout cl = (CardLayout) getLayout();
        cl.show(this, "ChipsMenu");
    }

    // Main menu with buttons for Sandwich, Drink, and Chips
    private JPanel createMainMenuPanel() {
        JPanel panel = new JPanel(new GridLayout(0, 1));

        JButton sandwichButton = new JButton("Sandwich - $5.00");
        sandwichButton.addActionListener(e -> showToppingsMenu());

        JButton drinkButton = new JButton("Drink - Choose Type and Size");
        drinkButton.addActionListener(e -> showDrinksMenu());

        JButton chipsButton = new JButton("Chips - $1.50");
        chipsButton.addActionListener(e -> showChipsMenu());

        panel.add(sandwichButton);
        panel.add(drinkButton);
        panel.add(chipsButton);

        return panel;
    }

        // Create toppings panel with buttons for each topping
    private JPanel createToppingsPanel() {
        JPanel panel = new JPanel(new GridLayout(0, 1));

        // Example toppings
        JButton cheeseButton = new JButton("Cheese - $0.50");
        cheeseButton.addActionListener(e -> OrderPanel.addOrderItem("Cheese", 0.50));

        JButton lettuceButton = new JButton("Lettuce - $0.30");
        lettuceButton.addActionListener(e -> OrderPanel.addOrderItem("Lettuce", 0.30));

        JButton tomatoButton = new JButton("Tomato - $0.40");
        tomatoButton.addActionListener(e -> OrderPanel.addOrderItem("Tomato", 0.40));

        // Add a "Back" button to return to the main menu
        JButton backButton = new JButton("Back to Main Menu");
        backButton.addActionListener(e -> showMainMenu());

        // Add topping buttons and back button to the panel
        panel.add(cheeseButton);
        panel.add(lettuceButton);
        panel.add(tomatoButton);
        panel.add(backButton);

        return panel;
    }

    // Drinks menu for selecting type and size
    private JPanel createDrinksPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        // Panel for drink type buttons
        JPanel drinkTypePanel = new JPanel(new GridLayout(0, 1));
        JLabel typeLabel = new JLabel("Choose Drink Type:");
        drinkTypePanel.add(typeLabel);

        // Drink type buttons
        JButton colaButton = new JButton("Cola");
        colaButton.addActionListener(e -> updateDrinkSelection("Cola", selectedDrinkSize));

        JButton waterButton = new JButton("Water");
        waterButton.addActionListener(e -> updateDrinkSelection("Water", selectedDrinkSize));

        drinkTypePanel.add(colaButton);
        drinkTypePanel.add(waterButton);

        // Panel for drink size buttons
        JPanel drinkSizePanel = new JPanel(new GridLayout(0, 1));
        JLabel sizeLabel = new JLabel("Choose Drink Size:");
        drinkSizePanel.add(sizeLabel);

        // Drink size buttons
        JButton smallButton = new JButton("Small - $0.50");
        smallButton.addActionListener(e -> updateDrinkSelection(selectedDrinkType, "Small"));

        JButton mediumButton = new JButton("Medium - $1.00");
        mediumButton.addActionListener(e -> updateDrinkSelection(selectedDrinkType, "Medium"));

        JButton largeButton = new JButton("Large - $1.50");
        largeButton.addActionListener(e -> updateDrinkSelection(selectedDrinkType, "Large"));

        drinkSizePanel.add(smallButton);
        drinkSizePanel.add(mediumButton);
        drinkSizePanel.add(largeButton);

        // Current selection display
        JPanel selectionPanel = new JPanel();
        selectionPanel.add(currentSelectionLabel);

        // OK button to finalize selection and return to main menu
        JButton okButton = new JButton("OK");
        okButton.addActionListener(e -> confirmDrinkSelection());

        selectionPanel.add(okButton);

        // Assemble the drink menu layout
        panel.add(drinkTypePanel, BorderLayout.WEST);
        panel.add(drinkSizePanel, BorderLayout.EAST);
        panel.add(selectionPanel, BorderLayout.SOUTH);

        return panel;
    }

    // Chips menu to choose a type (same price for all)
    private JPanel createChipsPanel() {
        JPanel panel = new JPanel(new GridLayout(0, 1));

        // Example chip types (all at the same price)
        JButton plainChipsButton = new JButton("Plain Chips - $1.50");
        plainChipsButton.addActionListener(e -> OrderPanel.addOrderItem("Plain Chips", 1.50));

        JButton bbqChipsButton = new JButton("BBQ Chips - $1.50");
        bbqChipsButton.addActionListener(e -> OrderPanel.addOrderItem("BBQ Chips", 1.50));

        JButton sourCreamChipsButton = new JButton("Sour Cream Chips - $1.50");
        sourCreamChipsButton.addActionListener(e -> OrderPanel.addOrderItem("Sour Cream Chips", 1.50));

        JButton backButton = new JButton("Back to Main Menu");
        backButton.addActionListener(e -> showMainMenu());

        panel.add(plainChipsButton);
        panel.add(bbqChipsButton);
        panel.add(sourCreamChipsButton);
        panel.add(backButton);

        return panel;
    }

    // Update the current drink selection and display it
    private void updateDrinkSelection(String drinkType, String drinkSize) {
        selectedDrinkType = drinkType;
        selectedDrinkSize = drinkSize;

        // Update the label to show the current selection
        String sizePrice = "";
        if (drinkSize.equals("Small")) sizePrice = "$0.50";
        else if (drinkSize.equals("Medium")) sizePrice = "$1.00";
        else if (drinkSize.equals("Large")) sizePrice = "$1.50";

        currentSelectionLabel.setText("Selected drink: " + drinkType + " (" + drinkSize + ") - " + sizePrice);
    }

    // Confirm selection and add it to the order, then return to main menu
    private void confirmDrinkSelection() {
        // Determine price based on drink size
        double price = 0.0;
        if (selectedDrinkSize.equals("Small")) price = 0.50;
        else if (selectedDrinkSize.equals("Medium")) price = 1.00;
        else if (selectedDrinkSize.equals("Large")) price = 1.50;

        // Add selected drink to the order if both type and size are chosen
        if (!selectedDrinkType.isEmpty() && !selectedDrinkSize.isEmpty()) {
            OrderPanel.addOrderItem(selectedDrinkType + " (" + selectedDrinkSize + ")", price);
            resetDrinkSelection();
            showMainMenu();
        } else {
            JOptionPane.showMessageDialog(this, "Please select both a drink type and size.");
        }
    }

    // Reset drink selection after confirming
    private void resetDrinkSelection() {
        selectedDrinkType = "";
        selectedDrinkSize = "";
        currentSelectionLabel.setText("Selected drink: None");
    }
}

//public class MenuPanel extends JPanel {
//
//private JPanel mainMenuPanel;
//    private JPanel toppingsPanel;
//
//    public MenuPanel() {
//        setLayout(new CardLayout()); // CardLayout to switch between panels
//
//        // Initialize the main menu and toppings menu
//        mainMenuPanel = createMainMenuPanel();
//        toppingsPanel = createToppingsPanel();
//
//        // Add panels to the CardLayout
//        add(mainMenuPanel, "MainMenu");
//        add(toppingsPanel, "ToppingsMenu");
//
//        // Show the main menu initially
//        showMainMenu();
//    }
//
//    // Show main menu
//    private void showMainMenu() {
//        CardLayout cl = (CardLayout) getLayout();
//        cl.show(this, "MainMenu");
//    }
//
//    // Show toppings menu
//    private void showToppingsMenu() {
//        CardLayout cl = (CardLayout) getLayout();
//        cl.show(this, "ToppingsMenu");
//    }
//
//    // Create the main menu panel with buttons for items
//    private JPanel createMainMenuPanel() {
//        JPanel panel = new JPanel(new GridLayout(0, 1));
//
//        JButton sandwichButton = new JButton("Sandwich - $5.00");
//        sandwichButton.addActionListener(e -> showToppingsMenu());
//
//        JButton drinkButton = new JButton("Drink - $2.00");
//        drinkButton.addActionListener(e -> OrderPanel.addOrderItem("Drink", 2.00));
//
//        JButton saladButton = new JButton("Salad - $4.00");
//        saladButton.addActionListener(e -> OrderPanel.addOrderItem("Salad", 4.00));
//
//        panel.add(sandwichButton);
//        panel.add(drinkButton);
//        panel.add(saladButton);
//
//        return panel;
//    }
//
//    // Create toppings panel with buttons for each topping
//    private JPanel createToppingsPanel() {
//        JPanel panel = new JPanel(new GridLayout(0, 1));
//
//        // Example toppings
//        JButton cheeseButton = new JButton("Cheese - $0.50");
//        cheeseButton.addActionListener(e -> OrderPanel.addOrderItem("Cheese", 0.50));
//
//        JButton lettuceButton = new JButton("Lettuce - $0.30");
//        lettuceButton.addActionListener(e -> OrderPanel.addOrderItem("Lettuce", 0.30));
//
//        JButton tomatoButton = new JButton("Tomato - $0.40");
//        tomatoButton.addActionListener(e -> OrderPanel.addOrderItem("Tomato", 0.40));
//
//        // Add a "Back" button to return to the main menu
//        JButton backButton = new JButton("Back to Main Menu");
//        backButton.addActionListener(e -> showMainMenu());
//
//        // Add topping buttons and back button to the panel
//        panel.add(cheeseButton);
//        panel.add(lettuceButton);
//        panel.add(tomatoButton);
//        panel.add(backButton);
//
//        return panel;
//    }
//}
