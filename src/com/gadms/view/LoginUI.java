package com.gadms.view;

import com.gadms.controller.LoginController;
import com.gadms.view.components.ButtonStyled;

import java.awt.*;
import java.io.IOException;
import java.util.Objects;

import javax.swing.*;

public class LoginUI extends JFrame {

    JTextField email;
    JPasswordField password;
    JLabel message;

    public LoginUI() {
        setTitle("AssetWise - Login");
//        getContentPane().setSize(300, 600);
//        getContentPane().setMinimumSize(getSize());
//        setLocationRelativeTo(null);

        JPanel log = new JPanel();
        log.setSize(800, 600);
        log.setBackground(new Color(255, 255, 255));
        log.setLayout(new BorderLayout());
//        JLabel bgi = new JLabel(new ImageIcon(Objects.requireNonNull(getClass().getResource("/com/gadms/assets/login_bgi.jpg"))));
//        log.add(bgi);
        add(log, BorderLayout.CENTER);
//        setContentPane(bgi);


        JLabel Heading = new JLabel("AssetWise");
        Heading.setForeground(new java.awt.Color(131, 126, 253));
        Heading.setBackground(new java.awt.Color(131, 126, 253));
        Heading.setFont(new Font("Times New Roman", Font.BOLD, 30));
        Heading.setForeground(Color.BLACK);
        Heading.setHorizontalAlignment(JLabel.CENTER);
        Heading.setBounds(90, 30, 350, 50);
        log.add(Heading);

        JLabel emailL = new JLabel("Email: ");
        emailL.setBounds(90, 130, 100, 20);
        emailL.setFont(new Font("Times New Roman", Font.BOLD, 15));
        log.add(emailL);

        email = new JTextField("");
        email.setBounds(200, 130, 100, 20);
        log.add(email);

        JLabel passwordL = new JLabel("Password: ");
        passwordL.setBounds(90, 170, 100, 20);
        passwordL.setFont(new Font("Times New Roman", Font.BOLD, 16));
        log.add(passwordL);

        password = new JPasswordField("");
        password.setBounds(200, 170, 100, 20);
        log.add(password);

//        Button2 loginBtn = new Button2();
//        loginBtn.setBackground(new java.awt.Color(157, 153, 255));
//        loginBtn.setForeground(new java.awt.Color(255, 255, 255));
//        loginBtn.setText("Login");
//        loginBtn.setEffectColor(new java.awt.Color(199, 196, 255));
//        loginBtn.addActionListener(evt -> {});

        JButton loginBtn = new JButton("Login");
        loginBtn.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        loginBtn.setBounds(90, 220, 100, 30);
        loginBtn.addActionListener(evt -> {
            String Email = email.getText();
            String Password = String.valueOf(password.getPassword());
            int res = LoginController.login(Email, Password);
            if (res == 1) {
                dispose();
                new UserDashboardUI();
            } else if (res == 2) {
                dispose();
                new AdminDashboardUI();
            } else {
                message.setText("Invalid email or password");
            }
        });
        log.add(loginBtn);


        message = new JLabel("");
        message.setFont(new Font("Times New Roman", Font.ITALIC, 16));
        message.setBounds(90, 270, 400, 20);
        message.setForeground(Color.BLACK);
        add(message);

        JButton signup = new JButton("Don't have an account? Sign up");
        signup.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        signup.setBackground(new Color(0,0,0, 0));
        signup.setFocusPainted(false);
        signup.setBorder(null);
        signup.setBounds(90, 320, 400, 50);
        signup.addActionListener(actionEvent -> {
            dispose();
            new RegisterUI();
        });
        log.add(signup);
        log.setLayout(null);
        add(log);

        setSize(600, 500);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) throws IOException {
        new LoginUI();
    }
}

class CenterAlign {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Center Align Panel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,600);
        frame.setBackground(Color.GRAY);
        frame.setContentPane(new JLabel(new ImageIcon(Objects.requireNonNull(CenterAlign.class.getResource("/com/gadms/assets/login_bgi.jpg")))));

        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(Color.WHITE);
        centerPanel.setLayout(new BorderLayout());
        JLabel Heading = new JLabel("AssetWise");
        Heading.setFont(new Font("Times New Roman", Font.BOLD, 30));
        Heading.setForeground(Color.BLACK);
        Heading.setHorizontalAlignment(JLabel.CENTER);
        Heading.setBounds(90, 30, 350, 50);
        centerPanel.add(Heading);

        JLabel emailL = new JLabel("Email: ");
        emailL.setBounds(90, 130, 100, 20);
        emailL.setFont(new Font("Times New Roman", Font.BOLD, 15));
        centerPanel.add(emailL);

        JTextField email = new JTextField("");
        email.setBounds(200, 130, 100, 20);
        centerPanel.add(email);

        JLabel passwordL = new JLabel("Password: ");
        passwordL.setBounds(90, 170, 100, 20);
        passwordL.setFont(new Font("Times New Roman", Font.BOLD, 16));
        centerPanel.add(passwordL);

        JPasswordField password = new JPasswordField("");
        password.setBounds(200, 170, 100, 20);
        centerPanel.add(password);

        JButton enter = new JButton("Login");
        enter.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        enter.setBounds(90, 220, 100, 30);
        centerPanel.add(enter);
        frame.add(centerPanel, BorderLayout.CENTER);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

class LoginUI2 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Login UI");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set background image
        ImageIcon backgroundImage = new ImageIcon(Objects.requireNonNull(LoginUI2.class.getResource("/com/gadms/assets/login_bgi.jpg")));
        JLabel background = new JLabel(backgroundImage);
        background.setBounds(0, 0, 800, 600);

        // Create translucent white screen for login form
        JPanel loginPanel = new JPanel();
        loginPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        loginPanel.setBounds(300, 200, 200, 200);
        loginPanel.setBackground(new Color(255, 255, 255, 100));

        // Add login form elements (username and password fields, login button)
        JLabel usernameLabel = new JLabel("Username:");
        JTextField usernameField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField();
        JButton loginButton = new JButton("Login");

        loginPanel.add(usernameLabel);
        loginPanel.add(usernameField);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordField);
        loginPanel.add(loginButton);

        // Add background image and login panel to frame
        frame.add(background);
        frame.add(loginPanel);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
    }
}