package ru.handbook.core;

import ru.handbook.model.Contact;
import ru.handbook.model.Group;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by asus on 11.07.2017.
 */
public class Main {
    public  static Serial serial;
    static Menu menu = new Menu();
    public static boolean flag = true;
    public static List<Contact> contacts = new ArrayList();
    public static List<Group> groups = new ArrayList();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        //testData();
        deSerialize();
        while (flag) {
            System.out.println("Entery #comand");
            System.out.println("0: searchContact\n 1: createContact\n 2: changeContact\n 3: deleteContact\n 4: searchGroup\n 5: createGroup\n 6: addInGroup\n 7: deleteFromGroup\n 8: checkContacts\n 9: checkGroups\n 10: deleteGroup\n 11: updateGroup\n 12: exitProgram");
            if (scanner.hasNextInt()) {
                menu.command(Integer.parseInt(scanner.nextLine()));
            } else throw new NotCorrectCommandException("Command must be integer");
        }
        serialize();
    }

    private static void serialize() {
        serial = new Serial();
        serial.setContacts(contacts);
        serial.setGroups(groups);
        try {
            createOOS().writeObject(serial);
            System.out.println("Serializing is success");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deSerialize() {
        ObjectInputStream objectInputStream = createOIS();
        try {
            Serial serial = (Serial) objectInputStream.readObject();
            int serialContactsLength = serial.getContacts().size();
            for (int i = 0; i < serialContactsLength; i++) {
                contacts.add(serial.getContacts().get(i));
            }
            int serialGroupLength = serial.getGroups().size();
            for (int i = 0; i < serialGroupLength; i++) {
                groups.add(serial.getGroups().get(i));
            }
            System.out.println("Read file success");
        } catch (IOException e) {
            deSerialize();
        } catch (ClassNotFoundException e) {
            System.out.println("Handbook have not component for reading file");
        }
    }

    public static ObjectInputStream createOIS() {
        try {
            System.out.println("Creating ObjectInputStream...");
            return new ObjectInputStream(createFIS());
        } catch (IOException e) {
            createOIS();
        }
        return createOIS();
    }

    public static FileInputStream createFIS() {
        try {
            System.out.println("Creating FileInputStream...");
            return new FileInputStream("temp.out");
        } catch (FileNotFoundException e) {
            createFile();
        }
        return createFIS();
    }

    private static ObjectOutputStream createOOS() {
        try {
            System.out.println("Creating ObjectOutputStream...");
            return new ObjectOutputStream(createFOS());
        } catch (IOException e) {
            createOOS();
        }
        return createOOS();
    }

    private static FileOutputStream createFOS() {
        try {
            System.out.println("Creating FileOutputStream...");
            return  new FileOutputStream("temp.out");
        } catch (FileNotFoundException e) {
            createFile();
            createFOS();
        }
        return createFOS();
    }

    private static File createFile() {
        String path = new File("").getAbsolutePath();
        System.out.println("Creating file for serialization...");
        return new File(path + "temp.out");
    }

    public static void testData() {
        Contact contact = new Contact("Ivan");
        contacts.add(contact);
        Group group = new Group("Friends");
        groups.add(group);
    }
}
