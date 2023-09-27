package com.neon.mainsource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;
public class myConvertor extends JFrame implements ActionListener{
    JComboBox fromcountry,tocountry;
    JButton convert,reset,exit;
    JLabel fromunit,tounit;
    TextField fromtext;
    TextField Answer;

    String[] currencyUnits=
            {
                    "units",
                    "Indian Rupee",
                    "Pakistani Rupee",
                    "US Dollar",
                    "Canadian Dollar",
                    "Kenyan Shilling",
                    "Nigerian Naira",
                    "Brazilian Real",
                    "Indonesian Rupiah",
                    "Philippine_Pisco",
                    "Taka",
            };

    double Indian_Rupee = 95.21;
    double Pakistani_Rupee = 162.74;
    double US_Dollar = 1.31;
    double Canadian_Dollar = 1.71;
    double Kenyan_Shilling = 132.53;
    double Nigerian_Naira = 476.57;
    double Brazilian_Real = 5.47;
    double Indonesian_Rupiah = 19554.94;
    double Philippine_Pisco = 71.17;
    double Bangladesh_Taka = 109.55;
    myConvertor()
    {
        setBounds(300,60,780,540);
        getContentPane().setBackground(Color.BLACK);

        JLabel maintitle = new JLabel("Currency Converter");
        maintitle.setBounds(70,30,650,80);
        maintitle.setFont(new Font("Ubntu",Font.BOLD,58));
        maintitle.setForeground(Color.green);
        add(maintitle);

        JLabel from = new JLabel("From");
        from.setBounds(30,160,100,50);
        from.setFont(new Font("Ubntu",Font.BOLD,22));
        from.setForeground(Color.green);
        add(from);

        fromcountry = new JComboBox(new String[] { "Select One..", "India", "Pakistan", "USA", "Canada", "Kenyan", "Ngeria", "Brazil", "Indonesia", "Philippine" ,"Bangladesh"});
        fromcountry.setBounds(100,165,200,40);
        fromcountry.setFont(new Font("Ubntu Mono",Font.BOLD,20));
      //  fromcountry.setForeground(new java.awt.Color(255,0, 255));
        
        fromcountry.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(ItemEvent evt) {
                fromcountryItemStateChanged(evt);
            }
        });
        add(fromcountry);

        fromtext = new TextField();
        fromtext.setBounds(350,165,250, 40);
        fromtext.setFont(new Font("Ubntu Mono",Font.BOLD,20));
        fromtext.setForeground(Color.blue);
        add(fromtext);

        fromunit = new JLabel("Unit");
        fromunit.setBounds(620,170,200,40);
        fromunit.setFont(new Font("Ubntu Mono",Font.BOLD,20));
        fromunit.setForeground(Color.white);
        add(fromunit);

        JLabel to = new JLabel("To");
        to.setBounds(50,300,100,50);
        to.setFont(new Font("Ubntu Mono",Font.BOLD,20));
        to.setForeground(Color.green);
        add(to);

        tocountry = new JComboBox(new String[] { "Select One..", "India", "Pakistan", "USA", "Canada", "Kenyan", "Ngeria", "Brazil", "Indonesia", "Philippine" ,"Bangladesh"});
        tocountry.setBounds(100,310,200,40);
        tocountry.setFont(new Font("Ubntu Mono",Font.BOLD,20));
        //tocountry.setForeground(Color.white);
        tocountry.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(ItemEvent evt) {
                tocountryItemStateChanged(evt);
            }
        });
        add(tocountry);

        Answer = new TextField(" ");
        Answer.setBounds(350,310,250, 40);
        Answer.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        Answer.setFont(new Font("Ubntu Mono",Font.BOLD,20));
        Answer.setForeground(Color.blue);
        add(Answer);

        tounit = new JLabel("Unit");
        tounit.setBounds(620,290,250,90);
        tounit.setFont(new Font("Ubntu Mono",Font.BOLD,20));
        tounit.setForeground(Color.white);
        add(tounit);

        convert = new MyButton();
        convert.setText("Convert");
        convert.setBorder(null);
        convert.setBounds(100,380,200,40);
        convert.setFont(new Font("Ubntu Mono",Font.BOLD,28));
        convert.setBackground(Color.black);
        convert.setForeground(new java.awt.Color(0,255, 0));
        convert.addActionListener(this);
        add(convert);


        reset = new MyButton();
        reset.setText("Reset");
        reset.setBorder(null);
        reset.setBounds(370,380,200,40);
        reset.setForeground(new java.awt.Color(0,255, 0));
        reset.setFont(new Font("Ubntu Mono",Font.BOLD,22));
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(reset);

        exit = new MyButton();
        exit.setText("Exit");
        exit.setBorder(null);
        exit.setBounds(290,440,100,40);
        exit.setForeground(new java.awt.Color(255,0, 0));
        exit.setFont(new Font("Ubntu Mono",Font.BOLD,20));
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        add(exit);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        //reset panel
        fromcountry.setSelectedIndex(0);
        tocountry.setSelectedIndex(0);
        fromtext.setText(null);
        Answer.setText(null);
    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        //to Exit
        System.exit(0);
    }

    public static void main(String[] args)
    {
        new myConvertor();
    }


    private void fromcountryItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_fromcountryItemStateChanged
        //units
        int position = fromcountry.getSelectedIndex();
        fromunit.setText(currencyUnits[position]);
    }

    private void tocountryItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_tocountryItemStateChanged
        //units
        int position = tocountry.getSelectedIndex();
        tounit.setText(currencyUnits[position]);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == convert) {
            if (fromcountry.getSelectedIndex() == 0 || tocountry.getSelectedIndex() == 0 || fromtext.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Invalid Input", "Getting Error", JOptionPane.ERROR_MESSAGE);

            } else {
                double amountToChange = Double.parseDouble(fromtext.getText());
                double amountInPounds = 0.0;
                //From Ammout change into pounds
                switch (fromcountry.getSelectedItem().toString()) {
                    case "India":
                        amountInPounds = amountToChange / Indian_Rupee;
                        break;
                    case "Pakistan":
                        amountInPounds = amountToChange / Pakistani_Rupee;
                        break;
                    case "USA":
                        amountInPounds = amountToChange / US_Dollar;
                        break;
                    case "Canada":
                        amountInPounds = amountToChange / Canadian_Dollar;
                        break;
                    case "Kenyan":
                        amountInPounds = amountToChange / Kenyan_Shilling;
                        break;
                    case "Ngeria":
                        amountInPounds = amountToChange / Nigerian_Naira;
                        break;
                    case "Brazil":
                        amountInPounds = amountToChange / Brazilian_Real;
                        break;
                    case "Indonesia":
                        amountInPounds = amountToChange / Indonesian_Rupiah;
                        break;
                    case "Philippine":
                        amountInPounds = amountToChange / Philippine_Pisco;
                        break;
                  case "Bangladesh":
                    amountInPounds = amountToChange / Bangladesh_Taka;
                break; // Don't forget to add the break statement
                    default:
                        amountInPounds = 0.0;
                }

                double newamount = 0.0;
                switch (tocountry.getSelectedItem().toString()) {
                    case "India":
                        newamount = amountInPounds * Indian_Rupee;
                    case "Pakistan":
                        newamount = amountInPounds * Pakistani_Rupee;
                        break;
                    case "USA":
                        newamount = amountInPounds * US_Dollar;
                        break;
                    case "Canada":
                        newamount = amountInPounds * Canadian_Dollar;
                        break;
                    case "Kenyan":
                        newamount = amountInPounds * Kenyan_Shilling;
                        break;
                    case "Ngeria":
                        newamount = amountInPounds * Nigerian_Naira;
                        break;
                    case "Brazil":
                        newamount = amountInPounds * Brazilian_Real;
                        break;
                    case "Indonesia":
                        newamount = amountInPounds * Indonesian_Rupiah;
                        break;
                    case "Philippine":
                        newamount = amountInPounds * Philippine_Pisco;
                        break;
                    case "Bangladesh":
                 newamount = amountInPounds * Bangladesh_Taka;
                break; // Don't forget to add the break statement
                    default:
                        newamount = amountInPounds = 0.0;
                }
                String amount = String.format("%.2f", newamount);
                Answer.setText(amount);
            }
        }


    }
}