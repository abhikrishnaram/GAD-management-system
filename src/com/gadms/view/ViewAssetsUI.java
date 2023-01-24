package com.gadms.view;

import com.gadms.controller.ProductController;
import com.gadms.model.Product;
import com.gadms.view.components.Page;

import java.awt.*;
import java.util.List;
import java.util.function.Function;
import javax.swing.*;

public class ViewAssetsUI extends Page {

    public ViewAssetsUI(){
        setTitle("Product View Page");
        List<Product> products = ProductController.getProducts();
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JScrollPane scrollPane = new JScrollPane();
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel cardPanel = new JPanel();
        cardPanel.setLayout(new FlowLayout());
        for (Product product : products) {

            JPanel productCard = new JPanel();
            productCard.setLayout(new BoxLayout(productCard, BoxLayout.Y_AXIS));
            productCard.setBorder(BorderFactory.createLineBorder(Color.black));
            productCard.setPreferredSize(new Dimension(250, 200));
            productCard.setMaximumSize(new Dimension(250, 200));
            productCard.setMinimumSize(new Dimension(250, 200));

            JLabel nameLabel = new JLabel("Name: " + product.getName());
            nameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
            productCard.add(nameLabel);

            JLabel priceLabel = new JLabel("Price: " + product.getPrice());
            priceLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
            productCard.add(priceLabel);

            JLabel descriptionLabel = new JLabel("Description: " + product.getDescription());
            descriptionLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
            productCard.add(descriptionLabel);

            JLabel quantityLabel = new JLabel("Quantity: " + product.getTotalQuantity());
            quantityLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
            productCard.add(quantityLabel);

            cardPanel.add(productCard);
        }

        scrollPane.setViewportView(cardPanel);
        add(mainPanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public ViewAssetsUI(Function<Void, Void> backHandler) {
        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> {
            backHandler.apply(null);
            dispose();
        });
        add(backButton, BorderLayout.NORTH);

        new ViewAssetsUI();
    }

    public static void main(String[] args) {
        new ViewAssetsUI();
    }
}