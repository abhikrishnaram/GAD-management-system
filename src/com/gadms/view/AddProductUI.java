package com.gadms.view;


import com.gadms.controller.ProductController;
import com.gadms.model.Product;
import com.gadms.view.components.Page;

import java.awt.*;
import java.math.BigDecimal;
import java.util.function.Function;
import javax.swing.*;

public class AddProductUI extends Page {
    private final JLabel message;
    private final JTextField nameField;
    private final JTextField priceField;
    private final JTextField quantityField;
    private final JTextArea descriptionArea;

    public static void main(String[] args) {
        new AddProductUI();
    }

    Function<Void, Void> goBack() {
        new AdminDashboardUI();
        return null;
    }

    public AddProductUI() {
        setTitle("Add Product Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        JLabel nameLabel = new JLabel("Name:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.EAST;
        constraints.insets = new Insets(5, 5, 5, 5);
        mainPanel.add(nameLabel, constraints);

        nameField = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.WEST;
        mainPanel.add(nameField, constraints);

        JLabel priceLabel = new JLabel("Price:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.anchor = GridBagConstraints.EAST;
        mainPanel.add(priceLabel, constraints);

        priceField = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.anchor = GridBagConstraints.WEST;
        mainPanel.add(priceField, constraints);

        JLabel descriptionLabel = new JLabel("Description:");
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.anchor = GridBagConstraints.EAST;
        mainPanel.add(descriptionLabel, constraints);

        descriptionArea = new JTextArea(5, 20);
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.anchor = GridBagConstraints.WEST;
        mainPanel.add(new JScrollPane(descriptionArea), constraints);

        JLabel quantityLabel = new JLabel("Quantity:");
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.anchor = GridBagConstraints.EAST;
        mainPanel.add(quantityLabel, constraints);

        quantityField = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 3;
        constraints.anchor = GridBagConstraints.WEST;
        mainPanel.add(quantityField, constraints);

        JButton addButton = new JButton("Add");
        constraints.gridx = 1;
        constraints.gridy = 4;
        constraints.anchor = GridBagConstraints.WEST;
        mainPanel.add(addButton, constraints);

        message = new JLabel("");
        message.setFont(new Font("Times New Roman", Font.ITALIC, 16));
        constraints.gridx = 1;
        constraints.gridy = 5;
        constraints.anchor = GridBagConstraints.WEST;
        message.setForeground(Color.BLACK);
        mainPanel.add(message);

        addButton.addActionListener(e -> {
            String name = nameField.getText();
            String price = priceField.getText();
            String description = descriptionArea.getText();
            String quantity = quantityField.getText();

            if (name.isEmpty() || price.isEmpty() || description.isEmpty() || quantity.isEmpty()) {
                JOptionPane.showMessageDialog(getContentPane(), "Please fill in all the fields.");
            } else {
                Product res = ProductController.addProduct(new Product(
                        -1, name, BigDecimal.valueOf(Float.parseFloat(price)), description, Integer.parseInt(quantity)
                ));

                if(res.getId() != -1){
                    dispose();
                    new ViewAssetsUI(goBack());
                } else {
                    message.setText("Creating product failed. Try again!");
                }
            }
        });

        add(mainPanel);
        setVisible(true);
    }
}

