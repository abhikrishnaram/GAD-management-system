package com.gadms.view.components;

import javax.swing.*;
import java.awt.*;

public class Button extends JButton {
    public Button(String text){
        setText(text);
        setBackground(new Color(0, 153, 255));
        setForeground(Color.WHITE);
        setFont(new Font("Arial", Font.BOLD, 18));
        setPreferredSize(new Dimension(200, 100));
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setFocusPainted(false);
    }
}
