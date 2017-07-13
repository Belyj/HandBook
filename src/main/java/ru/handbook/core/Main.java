package ru.handbook.core;

import ru.handbook.model.Contact;
import ru.handbook.model.Group;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * Created by asus on 11.07.2017.
 */
public class Main {
    static Menu menu = new Menu();
    public static boolean flag = true;
    public static List<Contact> contacts = new ArrayList();
    public static List<Group> groups = new ArrayList();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        testData();
        while (flag) {
            System.out.println("Entery #comand");
            System.out.println("0: searchContact\n 1: createContact\n 2: changeContact\n 3: deleteContact\n 4: searchGroup\n 5: createGroup\n 6: addInGroup\n 7: deleteFromGroup\n 8: checkContacts\n 9: checkGroups\n 10: deleteGroup\n 11: updateGroup\n 12: exitProgram");
            if (scanner.hasNextInt()) {
                menu.command(Integer.parseInt(scanner.nextLine()));
            } else throw new NotCorrectCommandException("Command must be integer");
        }
    }

    public static void testData() {
        Contact contact = new Contact("Ivan");
        contacts.add(contact);
        Group group = new Group("Friends");
        groups.add(group);
    }
}
