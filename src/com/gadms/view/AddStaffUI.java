package com.gadms.view;

import com.gadms.controller.UserController;
import com.gadms.model.User;
import com.gadms.view.components.Page;

import java.awt.*;
import javax.swing.*;
import java.util.List;

public class AddStaffUI extends Page {

    public static void main(String[] args) {
        new AddStaffUI();
    }

    public AddStaffUI() {
        setTitle("AssetWise - Add GAD staff");

        List<User> users = UserController.getUsers();

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new FlowLayout());

        JScrollPane scrollPane = new JScrollPane();
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel userPanel = new JPanel();
        userPanel.setLayout(new BoxLayout(userPanel, BoxLayout.Y_AXIS));


        for (User user : users) {
            JPanel userCard = new JPanel();
            userCard.setLayout(new BoxLayout(userCard, BoxLayout.Y_AXIS));
            userCard.setBorder(BorderFactory.createLineBorder(Color.black));
            userCard.setPreferredSize(new Dimension(250, 50));
            userCard.setMaximumSize(new Dimension(250, 50));
            userCard.setMinimumSize(new Dimension(250, 50));

            JLabel nameLabel = new JLabel("Name: " + user.getName());
            nameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
            userCard.add(nameLabel);

            JLabel emailLabel = new JLabel("Email: " + user.getEmail());
            emailLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
            userCard.add(emailLabel);

            JCheckBox checkBox = new JCheckBox();
            checkBox.setSelected(user.isStaff());
            checkBox.setAlignmentX(Component.RIGHT_ALIGNMENT);
            userCard.add(checkBox);

            userPanel.add(userCard);
        }

        JPanel buttonPanel = new JPanel();
        JButton makeStaffButton = new JButton("Make Staff");
        makeStaffButton.addActionListener(e -> {
            Component[] components = userPanel.getComponents();
            for (Component component : components) {
                JPanel userCard = (JPanel) component;
                Component[] innerComponents = userCard.getComponents();
                for (Component innerComponent : innerComponents) {
                    if (innerComponent instanceof JCheckBox checkBox) {
                        JLabel emailLabel = (JLabel) innerComponents[1];
                        String email = emailLabel.getText().split(": ")[1];
                        UserController.makeStaff(email, checkBox.isSelected());
                    }
                }
            }
        });
        buttonPanel.add(makeStaffButton);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        scrollPane.setViewportView(userPanel);

        add(mainPanel);
        pack();
    }
}

