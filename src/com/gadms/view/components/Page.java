package com.gadms.view.components;

import com.gadms.Global;
import com.gadms.view.AdminDashboardUI;
import com.gadms.view.LoginUI;
import com.gadms.view.Main;
import com.gadms.view.UserDashboardUI;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Page extends JFrame {
    public Page(){

        final JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout());
        ButtonStyled HomeBtn = new ButtonStyled("Home");
        ButtonStyled LogoutBtn = new ButtonStyled("Logout");
        menuBar.setForeground(new Color(245, 245, 245));
        menuBar.setBorder(BorderFactory.createMatteBorder(0,0, 10, 0 ,new Color(157, 153, 255)));
        HomeBtn.addActionListener(e -> {
            System.out.println("test");
            this.dispose();
            if(Global.user != null && Global.user.isStaff())
                new AdminDashboardUI();
            else
                new UserDashboardUI();
        });

        LogoutBtn.addActionListener(e -> {
            this.dispose();
            new Main().setVisible(true);
        });

        menuBar.add(HomeBtn);
        menuBar.add(Box.createHorizontalStrut(1080));
        menuBar.add(LogoutBtn);
        setJMenuBar(menuBar);

        setMaximumSize(new Dimension(1920, 1080));
        setMinimumSize(new Dimension(1280, 720));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(false);
        setResizable(false);
    }

    public void showUI(){
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
