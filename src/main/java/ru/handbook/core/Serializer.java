package ru.handbook.core;

import ru.handbook.model.Contact;
import ru.handbook.model.Group;

import java.io.*;

import static ru.handbook.core.Main.contacts;
import static ru.handbook.core.Main.groups;
import static ru.handbook.core.Main.serial;

/**
 * Created by asus on 15.07.2017.
 */
public class Serializer {
    static void serialize() {
        ObjectOutputStream objectOutputStream = createOOS();
        serial = new Serial();
        serial.setContacts(contacts);
        serial.setGroups(groups);
        try {
            objectOutputStream.writeObject(serial);
            System.out.println("Serializing is success");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                objectOutputStream.close();
            } catch (IOException e) {
                System.out.println("File did not create");
            }
        }
    }

    public static void deSerialize() {
        ObjectInputStream objectInputStream = createOIS();
        try {
            if (new File("temp.out").exists()) {
                System.out.println("File founded");
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
            }
        } catch (IOException e) {
            System.out.println("File for deserializing not found");
        } catch (ClassNotFoundException e) {
            System.out.println("Handbook have not component for reading file");
        }
    }

    public static ObjectInputStream createOIS() {
        try {
            String path = new File("").getAbsolutePath();
            //File fileName = new File(new File("").getAbsolutePath() + "temp.out");
            //if (new File(path + "temp.out").exists()) {
                System.out.println("Creating ObjectInputStream...");
                return new ObjectInputStream(createFIS());
            //} else System.out.println("File does not exist");
        } catch (IOException e) {
            System.out.println("File for serializing not found");
        }
        return null;
    }

    public static FileInputStream createFIS() {
        try {
            System.out.println("Creating FileInputStream...");
            return new FileInputStream("temp.out");
        } catch (FileNotFoundException e) {

        }
        System.out.println("File not found");
        return null;
    }

    private static File createFile() {
        String path = new File("").getAbsolutePath();
        System.out.println("Creating file for serialization...");
        File file = new File(path + "temp.out");
        return file;
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
}
