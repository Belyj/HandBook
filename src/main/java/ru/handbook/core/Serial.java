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

    public void setContacts(List<Contact> incomingContacts) {
        int contactsLength = contacts.size();
        for (int i = 0; i < contactsLength; i++) {
            contacts.add(incomingContacts.get(i));
        }
        System.out.println("Contacts: was serialized");
    }

    public void setGroups(List<Group> incomingGroups) {
        int groupssLength = groups.size();
        for (int i = 0; i < groupssLength; i++) {
            groups.add(incomingGroups.get(i));
        }
        System.out.println("Groups: was serialized");
    }
}
