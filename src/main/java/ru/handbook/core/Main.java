package ru.handbook.core;

import com.sun.corba.se.impl.oa.poa.ActiveObjectMap;
import sun.invoke.empty.Empty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * Created by asus on 11.07.2017.
 */
public class Main {
    public static List<Contact> contacts = new ArrayList();
    public static HashMap<String, ArrayList<Contact>> groups = new HashMap();
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Menu menu = new Menu();
        while (true) {
            System.out.println("Entery #comand");
            System.out.println("0: searchContact\n 1: createContact\n 2: changeContact\n 3: deleteContact\n 4: searchGroup\n 5: createGroup\n 6: addInGroup\n 7: deleteFromGroup\n 8: checkContacts\n 9: checkGroups\n 10: deleteGroup\n 11: updateGroup");
            int comand = Integer.parseInt(scanner.nextLine());
            menu.comand(comand);
        }
    }
}
