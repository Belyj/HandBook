package ru.handbook.Serialization;

import java.io.*;

import static ru.handbook.core.Main.contacts;
import static ru.handbook.core.Main.groups;
import static ru.handbook.core.Main.serial;

/**
 * Created by asus on 15.07.2017.
 */
public class Serializer {
    public static void serialize() {
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
                System.out.println("OutputStream did not ctreate");
            }
        }
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
