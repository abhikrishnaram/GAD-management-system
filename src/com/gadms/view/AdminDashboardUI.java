package com.gadms.view;

import com.gadms.view.components.Page;

import java.awt.*;
import javax.swing.*;

public class AdminDashboardUI extends Page {

    public static void main(String[] args) {
        new AdminDashboardUI();
    }

    public AdminDashboardUI() {
        setTitle("AssetWise - Admin Panel");

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new FlowLayout());

        JButton viewTicketButton = new JButton("View Ticket");
        viewTicketButton.addActionListener(e -> {
//                dispose();
            new ViewRequestsUI(true);
        });
        mainPanel.add(viewTicketButton);

        JButton viewProductButton = new JButton("View Product");
        viewProductButton.setBounds(50, 50, 100, 50);
        viewProductButton.addActionListener(e -> {
//                dispose();
            new ViewAssetsUI();
        });
        mainPanel.add(viewProductButton);

        JButton addProductButton = new JButton("Add Product");
        addProductButton.setBounds(50, 50, 100, 50);
        addProductButton.addActionListener(e -> {
//                dispose();
            new AddProductUI();
        });
        mainPanel.add(addProductButton);

        JButton addStaffButton = new JButton("Add Staff");
        addStaffButton.addActionListener(e -> {
//                dispose();
            new AddStaffUI();
        });
        mainPanel.add(addStaffButton);

        add(mainPanel);
        setVisible(true);
    }
}

