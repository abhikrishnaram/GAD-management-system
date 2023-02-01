package com.gadms.view;

import com.gadms.Global;
import com.gadms.view.components.Button;
import com.gadms.view.components.Page;

import java.awt.*;
import javax.swing.*;

public class UserDashboardUI extends Page {
    String user_name = "user";
    JLabel heading = new JLabel("Welcome "+ user_name);
    JPanel content = new JPanel();
    JButton view_requests = new Button("View Requests");
    JButton create_request = new Button("Create Request");
    JButton view_assets = new Button("View Assets");

    public UserDashboardUI() {
        setTitle("AssetWise - Homepage");
        setLayout(new BorderLayout());

        if(Global.user != null && Global.user.getName().length() > 0){
            user_name = Global.user.getName();
        }
        heading.setText("Welcome "+ user_name);
        heading.setFont(new Font("Arial", Font.BOLD, 20));
        heading.setHorizontalAlignment(SwingConstants.CENTER);
        heading.setMinimumSize(new Dimension(100, 100));
        add(heading, BorderLayout.NORTH);
        ImageIcon img = new ImageIcon("src/assets/login_bgi.jpg");
        JLabel background = new JLabel("",img,JLabel.CENTER);
        background.setBounds(228,106,949,545);
        getContentPane().add(background);
        content.setBackground(Color.WHITE);
        content.setLayout(new FlowLayout());
        content.add(view_requests);
        content.add(view_assets);
        content.add(create_request);
        add(content, BorderLayout.CENTER);

        view_requests.addActionListener(evt -> {
            this.dispose();
            new ViewRequestsUI();
        });

        view_assets.addActionListener(evt -> {
            this.dispose();
            new ViewAssetsUI();
        });

        create_request.addActionListener(evt -> {
            this.dispose();
            new ViewAssetsUI(true);
        });

        showUI();
    }

    public static void main(String[] args) {
        new UserDashboardUI();
    }
}
