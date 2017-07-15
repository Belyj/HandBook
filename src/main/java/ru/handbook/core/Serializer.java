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
            String path = String.valueOf(new File("").getAbsoluteFile());
            File fileName = new File(path + "temp.out");
            if (fileName.exists()) {
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
            System.out.println("File for serializing not found");
        } catch (ClassNotFoundException e) {
            System.out.println("Handbook have not component for reading file");
        }
    }

    public static ObjectInputStream createOIS() {
        try {
            //String path = String.valueOf(new File("").getAbsoluteFile());
            File fileName = new File(new File("").getAbsolutePath() + "temp.out");
            if (fileName.exists()) {
                System.out.println("Creating ObjectInputStream...");
                return new ObjectInputStream(createFIS());
            }
        } catch (IOException e) {
            System.out.println("File for serializing not found");
        }
        return createOIS();
    }

    public static FileInputStream createFIS() {
        try {
            System.out.println("Creating FileInputStream...");
            return new FileInputStream("/temp.out");
        } catch (FileNotFoundException e) {

        }
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
