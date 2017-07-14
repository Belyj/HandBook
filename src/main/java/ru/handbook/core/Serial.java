package ru.handbook.core;

import ru.handbook.model.Contact;
import ru.handbook.model.Group;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by operator1 on 14.07.2017.
 */
public class Serial implements Serializable {
    private List<Contact> contacts = new ArrayList();
    private List<Group> groups = new ArrayList();

    public List<Contact> getContacts() {
        return contacts;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }
}
