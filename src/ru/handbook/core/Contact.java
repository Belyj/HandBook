package ru.handbook.core;

/**
 * Created by operator1 on 11.07.2017.
 */
public class Contact {
    private String name;
    private String contactInfo;

    public Contact(String name, String contactInfo) {
        this.name = name;
        this.contactInfo = contactInfo;
    }

    public Contact(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void refactorContactName(String name) {
        this.name = name;
    }

    public void refactorContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }
}
