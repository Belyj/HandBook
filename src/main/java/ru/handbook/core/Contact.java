package ru.handbook.core;

/**
 * Created by asus on 11.07.2017.
 */
public class Contact implements Useable {

    String name = "";

    String value = "";



    public Contact(String name, String value) {
        this.name = name;
        this.value = value;
    }

//    public boolean isItEmpty() {
//        if (name!="") return true;
//        else return false;
//    }

    public void create() {

    }

    public void refactor(String name, String value) {
        this.name = name;
        this.value=value;
    }

    public void delete() {

    }

    public void addInGroup() {

    }

    public void removeFromGroup() {

    }

    public void info() {
        System.out.println("Name: " + name + "\n"+ "Value" + value);
    }
}
