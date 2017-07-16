package ru.handbook.Serialization;

import java.io.*;

import static ru.handbook.core.Main.contacts;
import static ru.handbook.core.Main.groups;

/**
 * Created by asus on 16.07.2017.
 */
public class Deserializer {
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
        } finally {
            if (new File(new File("").getAbsolutePath() + "temp.out").exists()) {
                try {
                    objectInputStream.close();
                    return;
                } catch (IOException e) {
                    System.out.println("Inputstream didnot created");
                    return;
                }
            }
            System.out.println("Inputstream didnot created");
        }
    }

    public static ObjectInputStream createOIS() {
        try {
            //String path = new File("").getAbsolutePath();
            if (new File("temp.out").exists()) {
            System.out.println("Creating ObjectInputStream...");
            return new ObjectInputStream(createFIS());
            } else System.out.println("File does not exist");
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
}
