package com.neon.mainsource;

import javax.swing.*;
import java.awt.*;

public class myframe extends JFrame {
    
    myframe()
    {
         
        this.setTitle("Calculator");
        this.setDefaultCloseOperation(myframe.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setSize(420,550);
        //this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.BLACK);
        
        ImageIcon logo = new ImageIcon("logo.png");
        
        this.setIconImage(logo.getImage());


       }


    
}


