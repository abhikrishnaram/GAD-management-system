package com.gadms.view.components;

import javax.swing.*;
import java.awt.*;

public class Page extends JFrame {
    public Page(){
//        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//        setPreferredSize(screenSize);
        setMaximumSize(new Dimension(1920, 1080));
        setMinimumSize(new Dimension(1280, 720));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }
}
