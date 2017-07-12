package ru.handbook.core;
import static ru.handbook.core.Main.flag;
import static ru.handbook.core.Main.contacts;
import static ru.handbook.core.Main.groups;
import static ru.handbook.core.Main.scanner;
import java.util.ArrayList;

/**
 * Created by operator1 on 12.07.2017.
 */
public class Menu {
    public void comand(int comand) {
        switch (comand) {
            case (0):
                //searchContact();
                break;
            case (1):
                //createContact();
                break;
            case (2):
                //updateContact();
                break;
            case (3):
                //deleteContact();
                break;
            case (4):
                //searchGroup();
                break;
            case (5):
                //createGroup();
                break;
            case (6):
               // addInGroup();
                break;
            case (7):
               // deleteFromGroup();
                break;
            case (8):
               // checkContacts();
                break;
            case (9):
                //checkGroups();
                break;
            case (10):
                //deleteGroup();
                break;
            case (11):
                //updateGroup();
                break;
            case (12):
                System.out.println("Exit from programm");
                flag = false;
            default:
                System.out.println("Handbook have not comand: " + comand);
        }
    }

    public void searchContact(String string) {
        System.out.println("Entery contact name");
//        String name = scanner.nextLine();
        int length = contacts.size();
        for (int i = 0; i < length; i++) {
            if (contacts.get(i).getName().equals(string)) {
                contacts.get(i).getContactInfo();
                return;
            }
        }
        System.out.println("Contact " + string + " does not exist");
    }

    public void createContact(String string) {
        System.out.println("Entery name of new contact");
//        String name = scanner.nextLine();
        Contact contact = new Contact();
        contact.setName(string);
        contacts.add(contact);
        System.out.println("Contact " +string + " was created");
    }

    public Contact updateContact(String string) {
        System.out.println("Entery contact name");
//        String name = scanner.nextLine();
        int length = contacts.size();
        for (int i = 0; i < length; i++) {
            if (contacts.get(i).getName().equals(string)) {
                System.out.println("Entery new name");
                //String quest = scanner.nextLine();
                return contacts.get(i);
//                contacts.get(i).setName(quest);
//                System.out.println("Entery new telephone");
//                quest = scanner.nextLine();
//                contacts.get(i).setTelephone(quest);
//                System.out.println("Entery new skype");
//                quest = scanner.nextLine();
//                contacts.get(i).setSkype(quest);
//                System.out.println("Entery new mail");
//                contacts.get(i).setMail(quest);
            } else return null;//System.out.println("Handbook have not: " + string);
        } return null;
    }

    public void deleteContact() {
        System.out.println("Entery name of deleted contact");
        String name = scanner.nextLine();
        int length = contacts.size();
        for (int i = 0; i < length; i++) {
            if (contacts.get(i).getName().equals(name)) {
                contacts.remove(i);
            }
        }
        System.out.println("Contact was removed");
    }

    public void searchGroup(String string) {
        System.out.println("Entery group name");
//        String groupName = scanner.nextLine();
        System.out.println(string + ":\n");
        if (!groups.isEmpty()) {
            if (groups.get(string) != null) {
                for (Contact contact : groups.get(string)) {
                    contact.getContactInfo();
                }
            } else System.out.println("Group " + string + " does not exist");
        } else System.out.println("Not any groups was existing");
    }

    public void createGroup(String string) {
        System.out.println("Entery group name");
//        String groupName = scanner.nextLine();
        if (!groups.containsKey(string)) {
            groups.put(string, new ArrayList<Contact>());
            System.out.println("Group " + string + " was created");
        } else System.out.println("Group " + string + " is exist");
    }

    public void addInGroup() {
        System.out.println("Entery group name");
        String groupName = scanner.nextLine();
        if (!groups.containsKey(groupName)) {
            groups.put(groupName, new ArrayList<Contact>());
            System.out.println("Group " + groupName + " was created");
        }
        System.out.println("Entery contact name");
        String name = scanner.nextLine();
        int length = contacts.size();
        for (int i = 0; i < length; i++) {
            if (contacts.get(i).getName().equals(name)) {
                contacts.get(i).getGroups().add(groupName);
                groups.get(groupName).add(contacts.get(i));
            }
        }
        System.out.println("Contact was add to the " + groupName + " group");
    }

    public void deleteFromGroup() {
        System.out.println("Entery group name");
        String groupName = scanner.nextLine();
        System.out.println("Entery contact name");
        String name = scanner.nextLine();
        int length = contacts.size();
        for (int i = 0; i < length; i++) {
            if (contacts.get(i).getName().equals(name)) {
                length = contacts.get(i).getGroups().size();
                for (int j = 0; j < length; j++) {
                    if (groups.get(groupName).get(j).equals(name)) {
                        groups.get(groupName).get(j).removeFromGroup(groupName);
                        groups.get(groupName).remove(j);
                    }
                }
            }
        }
        System.out.println("Contact wa removed from " + groupName);
    }

    public void checkContacts() {
        if (contacts.isEmpty()) {
            System.out.println("Have not any contacts");
        } else {
            for (Contact contact : contacts) {
                contact.getContactInfo();
            }
        }
    }

    public void checkGroups() {
        for (String key : groups.keySet()) {
            System.out.println(key);
        }
    }

    public void deleteGroup() {
        System.out.println("Entery name of group");
        String groupname = scanner.nextLine();
        groups.remove(groupname);
        System.out.println("Group " + groupname + " was removed");
    }

    public void updateGroup() {
        System.out.println("Entery name of group");
        String groupname = scanner.nextLine();
        System.out.println("Entery new group name");
        String newGroupName = scanner.nextLine();
        groups.put(newGroupName, (ArrayList<Contact>) groups.get(groupname).clone());
        groups.remove(groupname);
        System.out.println("Whant you change a contacts? (y)");
        String answer = scanner.nextLine();
        if (answer.equals("y")) {
            //updateContact();
        }
    }
}