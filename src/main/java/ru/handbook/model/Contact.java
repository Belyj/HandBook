package ru.handbook.model;

import java.util.ArrayList;

/**
 * Created by asus on 11.07.2017.
 */
public class Contact {

    private String contactName;
    private String telephone;
    private String skype;
    private String mail;
    private ArrayList<String> contactGroups;

    public Contact(String name) {
        this.contactName = name;
    }

    public void setName(String name) {
        this.contactName = name;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setContactGroup(String groupName) {
        contactGroups.add(groupName);
    }

    public void delete() {

    }

    public void addInGroup(String groupName) {
        contactGroups.add(groupName);
    }

    public void removeGroup(String groupName) {
        contactGroups.remove(groupName);
    }

    public void getContactInfo() {
        System.out.println("Name: " + getContactName() +
                            "\ntelehpone: " + getTelephone() +
                            "\nskype: " + getSkype() +
                            "\nmail: " + getMail() + "\n");
        System.out.println("Group list");
        if (contactGroups != null) {
            for (String group : contactGroups) {
                System.out.println(group);
            }
        } else System.out.println();
    }

    public String getContactName() {
        return contactName;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getSkype() {
        return skype;
    }

    public String getMail() {
        return mail;
    }

    public ArrayList<String> getGroups() {
        return contactGroups;
    }
}
