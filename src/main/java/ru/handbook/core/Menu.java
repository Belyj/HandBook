package ru.handbook.core;
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
                searchContact();
                break;
            case (1):
                createContact();
                break;
            case (2):
                updateContact();
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
            case (10):
                deleteGroup();
                break;
            case (11):
                updateGroup();
                break;
            default:
                System.out.println("Break");
        }
    }

    public void searchContact() {
        System.out.println("Entery contact name");
        String name = scanner.nextLine();
        int lenght = contacts.size();
        for (int i = 0; i < lenght; i++) {
            if (contacts.get(i).getName().equals(name)) {
                contacts.get(i).getContactInfo();
            }
        }
    }

    public void createContact() {
        System.out.println("Entery name of new contact");
        String name = scanner.nextLine();
        Contact contact = new Contact();
        contact.setName(name);
        contacts.add(contact);
        System.out.println(name + " was created");
    }

    public void updateContact() {
        System.out.println("Entery contact name");
        String name = scanner.nextLine();
        int lenght = contacts.size();
        for (int i = 0; i < lenght; i++) {
            if (contacts.get(i).getName().equals(name)) {
                System.out.println("Entery new name");
                String quest = scanner.nextLine();
                contacts.get(i).setName(quest);
                System.out.println("Entery new telephone");
                quest = scanner.nextLine();
                contacts.get(i).setTelephone(quest);
                System.out.println("Entery new skype");
                quest = scanner.nextLine();
                contacts.get(i).setSkype(quest);
                System.out.println("Entery new mail");
                contacts.get(i).setMail(quest);
            }
        }
    }

    public void deleteContact() {
        System.out.println("Entery name of deleted contact");
        String name = scanner.nextLine();
        int lenght = contacts.size();
        for (int i = 0; i < lenght; i++) {
            if (contacts.get(i).getName().equals(name)) {
                contacts.remove(i);
            }
        }
        System.out.println("Contact was removed");
    }

    public void searchGroup() {
        System.out.println("Entery group name");
        String groupName = scanner.nextLine();
        System.out.println(groupName + ":\n");
        if (!groups.get(groupName).isEmpty()) {
            for (Contact contact : groups.get(groupName)) {
                contact.getContactInfo();
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
        System.out.println("Entery contact name");
        String name = scanner.nextLine();
        int lenght = contacts.size();
        for (int i = 0; i < lenght; i++) {
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
        int lenght = contacts.size();
        for (int i = 0; i < lenght; i++) {
            if (contacts.get(i).getName().equals(name)) {
                lenght = contacts.get(i).getGroups().size();
                for (int j = 0; j < lenght; j++) {
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
            updateContact();
        }
    }
}
