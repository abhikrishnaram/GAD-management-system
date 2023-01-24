package com.gadms.view;

import com.gadms.controller.LoginController;

import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginUI extends JFrame {

    JTextField email;
    JPasswordField password;
    JLabel message;

    public LoginUI() {
        setTitle("AssetWise - Login");
        setSize(300, 600);
        setMinimumSize(getSize());
        setLocationRelativeTo(null);

        JPanel log = new JPanel();
        log.setSize(800, 600);
		log.setBackground(Color.WHITE);

        JLabel CMS = new JLabel("AssetWise");
        CMS.setFont(new Font("Times New Roman", Font.ITALIC, 30));
        CMS.setForeground(Color.BLACK);
        CMS.setBounds(90, 30, 350, 50);
        log.add(CMS);

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

        JButton enter = new JButton("Login");
        enter.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        enter.setBounds(90, 220, 100, 30);
        log.add(enter);


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
        setVisible(true);
        enter.addActionListener(evt -> {
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
    }

    public static void main(String[] args) {
        new LoginUI();
    }
}



