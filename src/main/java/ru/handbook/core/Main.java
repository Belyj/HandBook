package ru.handbook.core;

import com.sun.corba.se.impl.oa.poa.ActiveObjectMap;
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
            System.out.println("0: searchContact\n 1: createContact\n 2: changeContact\n 3: deleteContact\n 4: searchGroup\n 5: createGroup\n 6: addInGroup\n 7: deleteFromGroup\n 8: checkContacts\n 9: checkGroups");
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
                    changeContact();
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
                    break;
                case (7):
                    deleteFromGroup();
                    break;
                case (8):
                    checkContacts();
                    break;
                case (9):
                    checkGroups();
                    break;
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
            System.out.println(name + " with value: " + value + " was created");
        }

        public void changeContact() {
            System.out.println("Entery ID of contact");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.println("Entery new name");
            String name = scanner.nextLine();
            System.out.println("Entery new value");
            String value = scanner.nextLine();
            contacts.get(id).refactor(name, value);
            contacts.get(id).info();
            System.out.println("Contact changed in name: " + name + "\nvalue: " + value);
        }

        public void deleteContact() {
            System.out.println("Entery ID of deleted contact");
            int id = Integer.parseInt(scanner.nextLine());
            contacts.remove(id);
            System.out.println("Contact was removed");
        }

        public void searchGroup() {
            System.out.println("Entery group name");
            String groupName = scanner.nextLine();
            System.out.println(groupName + ":\n");
                if (!groups.get(groupName).isEmpty()) {
                    for (Contact contact : groups.get(groupName)) {
                        contact.info();
                    }
                } else System.out.println("Group " + groupName + " is empty");
        }

        public void createGroup() {
            System.out.println("Entery group name");
            String groupName = scanner.nextLine();
            if (!groups.containsKey(groupName)) {
                groups.put(groupName, new ArrayList<Contact>());
            } else System.out.println("Group " + groupName + " is exist");
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
            System.out.println("Contact was add to the " + groupName + " group");
        }

        public void deleteFromGroup() {
            System.out.println("Entery group name");
            String groupName = scanner.nextLine();
            System.out.println("Entery ID of contact");
            int id = Integer.parseInt(scanner.nextLine());
            groups.get(groupName).remove(id);
            System.out.println("Contact wa removed from " + groupName);
        }

        public void checkContacts() {
            if (contacts.isEmpty()) {
                System.out.println("Have not any contacts");
            } else {
                for (Contact contact : contacts) {
                    contact.info();
                }
            }
        }

        public void checkGroups() {
            for (String key : groups.keySet()) {
                System.out.println(key);
            }
        }
    }
}
