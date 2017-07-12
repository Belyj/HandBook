package ru.handbook.core;

import java.util.ArrayList;

/**
 * Created by asus on 11.07.2017.
 */
public class Contact {

    private String name;
    private String telephone;
    private String skype;
    private String mail;
    private ArrayList<String> groups;

    public void setName(String name) {
        this.name = name;
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

    public void setGroups(ArrayList<String> groups) {
        this.groups = groups;
    }

    public void delete() {

    }

    public void addInGroup(String groupName) {
        groups.add(groupName);
    }

    public void removeFromGroup(String groupName) {
        groups.remove(groupName);
    }

    public void getContactInfo() {
        System.out.println("Name: " + getName() +
                            "\ntelehpone: " + getTelephone() +
                            "\nskype: " + getSkype() +
                            "\nmail: " + getMail() + "\n");
        System.out.println("Group list");
        for (String group : groups) {
            System.out.println(group);
        }
    }

    public String getName() {
        return name;
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
        return groups;
    }
}
