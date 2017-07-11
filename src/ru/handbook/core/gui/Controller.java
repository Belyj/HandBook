package ru.handbook.core.gui;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import ru.handbook.core.Contact;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;

public class Controller {
    @FXML
    TextArea list;
    @FXML
    TextField search;
    @FXML
    Button contacts;
    @FXML
    Button groups;
    @FXML
    Button create;
    @FXML
    Button refactor;
    @FXML
    Button delete;
    @FXML
    Button addInGroup;
    @FXML
    Button deleteFromGroup;
    @FXML
    Button checkInfo;
    HashMap<String, Contact> contactList = new HashMap();
    HashMap<String, List<Contact>> groupList = new HashMap<>();
    boolean mod = true;
    public void changeMod() {
        if (mod){
            mod = false;
            contacts.setText("Groups");
        } else {
            mod = true;
            contacts.setText("Contacts");
        }
    }

    public Contact searchingContact(String name) {
        return contactList.get(name);
    }

    public void create() {
        JTextField jName = new JTextField(30);
        JTextField jContactInfo = new JTextField(30);
        JFrame frame = new JFrame();
        frame.setSize(200, 100);
        JPanel panel = new JPanel();
        frame.add(panel);
        panel.setLayout(new BorderLayout());
        panel.add(jName, BorderLayout.WEST);
        final String[] name = new String[1];
        final String[] contactInfo = new String[1];
        jName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                name[0] = jName.getText();
                jName.removeActionListener(this);
            }
        });
        if (mod) {
            panel.add(jContactInfo, BorderLayout.EAST);
            jContactInfo.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    contactInfo[0] = jContactInfo.getText();
                    jContactInfo.removeActionListener(this);
                }
            });
        }

        frame.setVisible(true);
        if (mod = true) {
            Contact contact = new Contact(name[0], contactInfo[0]);
            contactList.put(contact.getName(), contact);
        } else {
            groupList.put(name[0], null);
        }
    }

    public Contact checkInfo() {
        JTextField jName = new JTextField(30);
        JFrame frame = new JFrame();
        frame.setSize(200, 100);
        JPanel panel = new JPanel();
        frame.add(panel);
        panel.setLayout(new BorderLayout());
        panel.add(jName, BorderLayout.WEST);
        final String[] name = new String[1];
        jName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                name[0] = jName.getText();
                jName.removeActionListener(this);
            }
        });
        return contactList.get(name);
    }

    public void delete() {
        JTextField jName = new JTextField(30);
        JFrame frame = new JFrame();
        frame.setSize(200, 100);
        JPanel panel = new JPanel();
        frame.add(panel);
        panel.setLayout(new BorderLayout());
        panel.add(jName, BorderLayout.WEST);
        final String[] name = new String[1];
        jName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                name[0] = jName.getText();
                jName.removeActionListener(this);
            }
        });
        if (mod) contactList.remove(name);
        else groupList.remove(name);

    }

    public void refactor() {
        JTextField jName = new JTextField(30);
        JFrame frame = new JFrame();
        frame.setSize(200, 100);
        JPanel panel = new JPanel();
        frame.add(panel);
        panel.setLayout(new BorderLayout());
        panel.add(jName, BorderLayout.WEST);
        final String[] name = new String[1];
        jName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                name[0] = jName.getText();
                jName.removeActionListener(this);
            }
        });
            create();
        if (mod) contactList.remove(name);
        else groupList.remove(name);
    }

    public void searchingGroup(String name) {
        groupList.get(name);
    }

    public void deleteGroup(String name) {
        groupList.remove(name);
    }

    public void refactorGroup(String name) {
        groupList.remove(name);
    }
}
