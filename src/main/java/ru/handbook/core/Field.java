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
        final Menu menu = new Menu();
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
        final JTextField searchingField = new JTextField();
        searchingField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (mod) {
                    menu.searchContact(searchingField.getText());
                } else {
                    menu.searchGroup(searchingField.getText());
                }
                searchingField.setText("");
            }
        });
        northPanel.add(modButton, BorderLayout.WEST);
        northPanel.add(searchingField, BorderLayout.CENTER);
        JPanel eastPanel = new JPanel(new BorderLayout());
        JButton createButton = new JButton("Create");
        createButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                final JFrame jFrame = new JFrame();
                jFrame.setSize(100, 100);
                final JTextField jTextField = new JTextField();
                jFrame.add(jTextField);
                jFrame.setVisible(true);
                if (mod) {
                    jTextField.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            menu.createContact(jTextField.getText());
                        }
                    });
                } else {
                    jTextField.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            menu.createGroup(jTextField.getText());
                        }
                    });
                }
            }
        });
        JButton updateButton = new JButton("Update");
        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                final JFrame jFrame = new JFrame();
                jFrame.setSize(100, 100);
                final JTextField jTextField = new JTextField();
                jFrame.add(jTextField);
                jFrame.setVisible(true);
                if (mod) {
                    jTextField.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            final Contact curentContact = menu.updateContact(jTextField.getText());
                            JFrame contactInfo = new JFrame();
                            contactInfo.setSize(100, 400);
                            contactInfo.setLayout(new GridLayout(4, 1));
                            final JTextField newNameField = new JTextField("Name");
                            final JTextField setTelephoneField = new JTextField("Telephone");
                            final JTextField setSkypeField = new JTextField("Skype");
                            final JTextField setMailField = new JTextField("Mail");
                            contactInfo.add(newNameField);
                            contactInfo.add(setTelephoneField);
                            contactInfo.add(setSkypeField);
                            contactInfo.add(setMailField);
                            contactInfo.setVisible(true);
                            newNameField.addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    curentContact.setName(newNameField.getText());
                                    System.out.println("Name changed on: " + newNameField.getText());
                                }
                            });
                            setTelephoneField.addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    curentContact.setTelephone(setTelephoneField.getText());
                                    System.out.println("Set telephone: " + setTelephoneField.getText());
                                }
                            });
                            setSkypeField.addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    curentContact.setSkype(setSkypeField.getText());
                                    System.out.println("Set Skype: " + setSkypeField.getText());
                                }
                            });
                            setMailField.addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    curentContact.setMail(setMailField.getText());
                                    System.out.println("Set Mail: " + setMailField.getText());
                                }
                            });
                        }
                    });
                } else {
                    jTextField.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            //menu.updateGroup(jTextField.getText());
                        }
                    });
                }
            }
        });

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
}
