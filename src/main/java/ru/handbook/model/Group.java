package ru.handbook.model;

import java.util.ArrayList;

/**
 * Created by operator1 on 13.07.2017.
 */
public class Group {

    private String groupName;

    private ArrayList<String> groupContacts;

    public Group(String name) {
        this.groupName = name;
    }

    public String getGroupName() {
        return groupName;
    }

    public ArrayList<String> getGroupContacts() {
        return groupContacts;
    }

    public void setName(String name) {
        this.groupName = name;
    }

    public void setGroupContact(String contactName) {
        groupContacts.add(contactName);
    }

    public void getGroupInfo() {
        System.out.println(groupName + ":\n");
        int length = groupContacts.size();
        for (int i = 0; i < length; i++) {
            System.out.println(groupContacts.get(i));
        }
    }

    public void removeContact(String name) {
        groupContacts.remove(name);
    }
}
