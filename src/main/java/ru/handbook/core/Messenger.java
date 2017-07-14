package ru.handbook.core;

/**
 * Created by operator1 on 14.07.2017.
 */
public class Messenger {
    final public void contactNameRequest() {
        System.out.println("Entery contact name");
    }

    final public void groupNameRequest() {
        System.out.println("Entery group  name");
    }

    final public void contactNameNonexistent(String name) {
        System.out.println("Contact " + name + "does not exist");
    }

    final public void groupNameNonexistent(String name) {
        System.out.println("Group " + name + "does not exist");
    }
}
