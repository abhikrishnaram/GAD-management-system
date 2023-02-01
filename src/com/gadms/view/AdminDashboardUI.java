package com.gadms.view;

import com.gadms.view.components.Button;
import com.gadms.view.components.Page;

import java.awt.*;
import javax.swing.*;

public class AdminDashboardUI extends Page {

    public static void main(String[] args) {
        new AdminDashboardUI();
    }

    public AdminDashboardUI() {
        setTitle("AssetWise - Admin Panel");
        setLayout(new FlowLayout());

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttonPanel = new JPanel();

        JButton viewTicketButton = new Button("View Ticket");
        viewTicketButton.addActionListener(e -> {
            this.dispose();
            new ViewRequestsUI();
        });
        buttonPanel.add(viewTicketButton);

        JButton viewProductButton = new Button("View Product");
        viewProductButton.addActionListener(e -> {
            this.dispose();
            new ViewAssetsUI();
        });
        buttonPanel.add(viewProductButton);

        JButton addProductButton = new Button("Add Product");
        addProductButton.addActionListener(e -> {
            this.dispose();
            new AddProductUI();
        });
        buttonPanel.add(addProductButton);

        JButton addStaffButton = new Button("Add GAD Staff");
        addStaffButton.addActionListener(e -> {
            this.dispose();
            new AddStaffUI();
        });
        buttonPanel.add(addStaffButton);

        mainPanel.add(buttonPanel);

        add(mainPanel);
        showUI();
    }
}

