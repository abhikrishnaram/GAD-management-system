package com.gadms.view;

import com.gadms.view.components.Button;
import com.gadms.view.components.Page;

import java.awt.*;
import javax.swing.*;

public class UserDashboardUI extends Page {

    JLabel heading = new JLabel("Welcome user");
    JPanel content = new JPanel();
    JButton view_requests = new Button("View Requests");
//    JButton create_request = new Button("Create Request");
    JButton view_assets = new Button("View Assets");

    public UserDashboardUI() {
        setTitle("AssetWise - Homepage");
        setLayout(new BorderLayout());

        heading.setFont(new Font("Arial", Font.BOLD, 20));
        heading.setHorizontalAlignment(SwingConstants.CENTER);
        heading.setMinimumSize(new Dimension(100, 100));
        add(heading, BorderLayout.NORTH);

        content.setBackground(Color.WHITE);
        content.setLayout(new FlowLayout());
        content.add(view_requests);
        content.add(view_assets);
//        content.add(create_request);
        add(content, BorderLayout.CENTER);

        view_requests.addActionListener(evt -> new ViewRequestsUI());

        view_assets.addActionListener(evt -> new ViewAssetsUI());

//        create_request.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent evt) {
//
//            }
//        });
    }

    public static void main(String[] args) {
        new UserDashboardUI();
    }
}
