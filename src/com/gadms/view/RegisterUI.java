package com.gadms.view;

import com.gadms.controller.RegisterController;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class RegisterUI extends JFrame {

    JTextField email, name;
    JPasswordField password, cpassword;
    JLabel message;

    public RegisterUI() {
        setTitle("AssetWise - Sign Up");
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

        JLabel nameL = new JLabel("Name: ");
        nameL.setBounds(90, 130, 100, 20);
        nameL.setFont(new Font("Times New Roman", Font.BOLD, 15));
        log.add(nameL);

        name = new JTextField("");
        name.setBounds(90, 150, 300, 20);
        log.add(name);

        JLabel emailL = new JLabel("Email: ");
        emailL.setBounds(90, 200, 300, 20);
        emailL.setFont(new Font("Times New Roman", Font.BOLD, 15));
        log.add(emailL);

        email = new JTextField("");
        email.setBounds(90, 220, 300, 20);
        log.add(email);

        JLabel passwordL = new JLabel("Password: ");
        passwordL.setBounds(90, 270, 300, 20);
        passwordL.setFont(new Font("Times New Roman", Font.BOLD, 16));
        log.add(passwordL);

        password = new JPasswordField("");
        password.setBounds(90, 290, 300, 20);
        log.add(password);

        JLabel cpasswordL = new JLabel("Confirm password: ");
        cpasswordL.setBounds(90, 340, 300, 20);
        cpasswordL.setFont(new Font("Times New Roman", Font.BOLD, 16));
        log.add(cpasswordL);

        cpassword = new JPasswordField("");
        cpassword.setBounds(90, 360, 300, 20);
        log.add(cpassword);

        JButton enter = new JButton("Get Started");
        enter.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        enter.setBounds(90, 400, 200, 35);
        log.add(enter);

        JButton signin = new JButton("Already have an account? Login");
        signin.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        signin.setBackground(new Color(0,0,0, 0));
        signin.setFocusPainted(false);
        signin.setBorder(null);
        signin.setBounds(90, 450, 400, 50);
        signin.addActionListener(actionEvent -> {
            dispose();
            new LoginUI();
        });
        log.add(signin);

        message = new JLabel("");
        message.setFont(new Font("Times New Roman", Font.ITALIC, 16));
        message.setBounds(90, 420, 300, 20);
        message.setForeground(Color.BLACK);
        log.add(message);

        log.setLayout(null);
        add(log);

        setSize(600, 500);
        setLayout(null);
        setVisible(true);
        enter.addActionListener(actionEvent -> {
            String Email = email.getText();
            String Name = name.getText();
            String Password = String.valueOf(password.getPassword());
            String CPassword = String.valueOf(cpassword.getPassword());
            if (RegisterController.run(Name, Email, Password, CPassword) == 1) {
                dispose();
                new UserDashboardUI();
            } else {
                message.setText("An error occurred!");
            }
        });
    }

    public static void main(String[] args) {
        new RegisterUI();
    }
}



