package ru.handbook.core;

import sun.invoke.empty.Empty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by asus on 11.07.2017.
 */
public class Main {
    public static ArrayList<Contact> contacts = new ArrayList();
    public static HashMap<String, ArrayList<Contact>> groups = new HashMap();
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Chooser chooser = new Chooser();
        while (true) {
            System.out.println("Entery #comand");
            int comand = Integer.parseInt(scanner.nextLine());
            chooser.comand(comand);
        }
    }

    public static class Chooser {
        public void comand(int comand) {
            switch (comand) {
                case (0):
                    searchContact();
                    break;
                case (1):
                    createContact();
                    break;
                case (2):
                    refactoryContact();
                    break;
                case (3):
                    deleteContact();
                    break;
                case (4):
                    searchGroup();
                    break;
                case (5):
                    createGroup();
                    break;
                case (6):
                    addInGroup();
                default:
                    System.out.println("Break");
            }
    }


        public void searchContact() {
            System.out.println("Entery ID of contact");
            int id = Integer.parseInt(scanner.nextLine());
            contacts.get(id).info();
        }

        public void createContact() {
            System.out.println("Entery name of new contact");
            String name = scanner.nextLine();
            System.out.println("Entery value for " + name);
            String value = scanner.nextLine();
            contacts.add(new Contact(name, value));
        }

        public void refactoryContact() {
            System.out.println("Entery ID of contact");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.println("Entery new name");
            String name = scanner.nextLine();
            System.out.println("Entery new value");
            String value = scanner.nextLine();
            contacts.get(id).refactor(name, value);
            contacts.get(id).info();
        }

        public void deleteContact() {
            System.out.println("Entery ID of deleted contact");
            int id = Integer.parseInt(scanner.nextLine());
            contacts.remove(id);
        }

        public void searchGroup() {
            System.out.println("Entery group name");
            String name = scanner.nextLine();
            System.out.println(name + ":\n");
                if (!groups.get(name).isEmpty()) {
                    for (Contact contact : groups.get(name)) {
                        contact.info();
                    }
                } else System.out.println("Group is empty");
        }

        public void createGroup() {
            System.out.println("Entery group name");
            String name = scanner.nextLine();
            if (!groups.containsKey(name)) {
                groups.put(name, new ArrayList<Contact>());
            } else System.out.println("Group " + name + " is exist");
        }

        public void addInGroup() {
            System.out.println("Entery group name");
            String groupName = scanner.nextLine();
            if (!groups.containsKey(groupName)) {
                groups.put(groupName, new ArrayList<Contact>());
                System.out.println("Group " + groupName + " was created");
            }
            System.out.println("Entery ID of contact");
            int id = Integer.parseInt(scanner.nextLine());
            groups.get(groupName).add(contacts.get(id));
        }
    }
}
