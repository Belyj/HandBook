package ru.handbook.core;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static ru.handbook.core.Main.mod;
/**
 * Created by asus on 12.07.2017.
 */
public class Field extends JFrame {
    public Field() {
        setTitle("Handbook");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(400, 100, 500, 500);
        setLayout(new BorderLayout());
        JPanel northPanel = new JPanel(new BorderLayout());
        final JButton modButton = new JButton("Contacts");
        modButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (mod) {
                    modButton.setText("Groups");
                    mod = false;
                } else {
                    modButton.setText("Contacts");
                    mod = true;
                }
            }
        });
        JTextField searchingFrame = new JTextField("Searching");
        northPanel.add(modButton, BorderLayout.WEST);
        northPanel.add(searchingFrame, BorderLayout.CENTER);
        JPanel eastPanel = new JPanel(new BorderLayout());
        JButton createButton = new JButton("Create");
        JButton updateButton = new JButton("Update");
        JButton deleteButton = new JButton("Delete");
        eastPanel.add(createButton, BorderLayout.NORTH);
        eastPanel.add(updateButton, BorderLayout.CENTER);
        eastPanel.add(deleteButton, BorderLayout.SOUTH);
        JPanel westPanel = new JPanel(new BorderLayout());
        JButton checkButton = new JButton("Chek");
        JButton addGroupButton = new JButton("Add group");
        JButton removeGroupButton = new JButton("Remove group");
        westPanel.add(checkButton, BorderLayout.NORTH);
        westPanel.add(addGroupButton, BorderLayout.CENTER);
        westPanel.add(removeGroupButton, BorderLayout.SOUTH);
        JTable table = new JTable();
        this.add(northPanel, BorderLayout.NORTH);
        this.add(eastPanel, BorderLayout.WEST);
        this.add(westPanel, BorderLayout.EAST);
        this.add(table, BorderLayout.CENTER);
        this.setVisible(true);
    }

    public void mod() {
        if (mod) {

        }
    }
}
