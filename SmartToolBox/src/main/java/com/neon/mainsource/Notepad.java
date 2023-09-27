package com.neon.mainsource;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Notepad extends JFrame implements ActionListener {

    private JTextArea textArea;
    private JFileChooser fileChooser;

    public Notepad() {
        setTitle(" Notepad");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        createMenuBar();
        createTextArea();

        setVisible(true);
    }

    private void createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(Color.BLACK); // Set menu bar background color to black
    
        JMenu fileMenu = new JMenu("File");
        fileMenu.setForeground(Color.RED); // Set menu font color to red
        
        JMenuItem newMenuItem = new JMenuItem("New");
        newMenuItem.addActionListener(this);
        newMenuItem.setForeground(Color.RED);
         newMenuItem.setBackground(Color.BLACK); // Set menu item font color to red
        fileMenu.add(newMenuItem);
    
        JMenuItem openMenuItem = new JMenuItem("Open");
        openMenuItem.addActionListener(this);
        openMenuItem.setForeground(Color.RED);
        openMenuItem.setBackground(Color.BLACK); // Set menu item font color to red
        fileMenu.add(openMenuItem);
    
        JMenuItem saveMenuItem = new JMenuItem("Save");
        saveMenuItem.addActionListener(this);
        saveMenuItem.setForeground(Color.RED);
        saveMenuItem.setBackground(Color.BLACK); // Set menu item font color to red
        fileMenu.add(saveMenuItem);
    
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.addActionListener(this);
        exitMenuItem.setForeground(Color.RED);
        exitMenuItem.setBackground(Color.BLACK);  // Set menu item font color to red
        fileMenu.add(exitMenuItem);
    
        menuBar.add(fileMenu);
    
        setJMenuBar(menuBar);
    }

    private void createTextArea() {
        textArea = new JTextArea();
        textArea.setCaretColor(textArea.getBackground().darker());
        textArea.setFont(new Font("Mooli", Font.PLAIN, 20));
        textArea.setBackground(Color.black); // Set background color to black
        textArea.setForeground(Color.green); // Set text color to white
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void newFile() {
        textArea.setText("");
    }

    private void openFile() {
        fileChooser = new JFileChooser();
        int option = fileChooser.showOpenDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                textArea.setText("");
                String line;
                while ((line = reader.readLine()) != null) {
                    textArea.append(line + "\n");
                }
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void saveFile() {
        fileChooser = new JFileChooser();
        int option = fileChooser.showSaveDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                writer.write(textArea.getText());
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "New":
                newFile();
                break;
            case "Open":
                openFile();
                break;
            case "Save":
                saveFile();
                break;
            case "Exit":
                System.exit(0);
                break;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Notepad());
    }
}