package ru.handbook.Controller;

import ru.handbook.core.Messenger;
import ru.handbook.model.Contact;
import ru.handbook.model.Group;
import ru.handbook.Controller.*;

import static ru.handbook.core.Main.contacts;
import static ru.handbook.core.Main.groups;
import static ru.handbook.core.Main.scanner;

/**
 * Created by operator1 on 14.07.2017.
 */
public class MenuController {
    Messenger messenger = new Messenger();

    public void searchContact() {
        new ContactActions().search();
    }

    public void createContact() {
        new ContactActions().create();
    }

    public void updateContact() {
        new ContactActions().update();
    }

    public void deleteContact() {
        new ContactActions().delete();
    }

    public void addInGroup() {
        new ContactActions().addInGroup();
    }

    public void deleteFromGroup() {
        new ContactActions().deleteFromGroup();
    }

    public void checkContacts() {
        new ContactActions().check();
    }

    public void searchGroup() {
        new GroupActions().search();
    }

    public void createGroup() {
        new GroupActions().create();
    }

    public void checkGroups() {
        new GroupActions().check();
    }

    public void deleteGroup() {
        new GroupActions().delete();
    }

    public void updateGroup() {
        new GroupActions().update();
    }
}
