package ru.handbook.Controller;

import ru.handbook.model.Contact;
import ru.handbook.model.Group;

import static ru.handbook.core.Main.contacts;
import static ru.handbook.core.Main.groups;
import static ru.handbook.core.Main.scanner;

/**
 * Created by operator1 on 14.07.2017.
 */
public class MenuController {
    public void searchContact() {
        System.out.println("Entery contact name");
        String name = scanner.nextLine();
        int length = contacts.size();
        for (int i = 0; i < length; i++) {
            if (contacts.get(i).getContactName().equals(name)) {
                contacts.get(i).getContactInfo();
                return;
            }
        }
        System.out.println("Contact " + name + " does not exist");
    }

    public void createContact() {
        System.out.println("Entery name of new contact");
        String name = scanner.nextLine();
        if (!name.equals("")) {
            Contact contact = new Contact(name);
            contacts.add(contact);
            System.out.println(name + " was created");
        } else System.out.println("Name can not be empty");
    }

    public void updateContact() {
        System.out.println("Entery contact name");
        String name = scanner.nextLine();
        int length = contacts.size();
        for (int i = 0; i < length; i++) {
            if (contacts.get(i).getContactName().equals(name)) {
                System.out.println("Entery new name");
                String newName = scanner.nextLine();
                contacts.get(i).setContactName(newName);
                System.out.println("Entery new telephone");
                String quest = scanner.nextLine();
                contacts.get(i).setTelephone(quest);
                System.out.println("Entery new skype");
                quest = scanner.nextLine();
                contacts.get(i).setSkype(quest);
                System.out.println("Entery new mail");
                quest = scanner.nextLine();
                contacts.get(i).setMail(quest);
                for (int j = 0; j < length; j++) {
                    if (contacts.get(j).getContactName().equals(newName)) {
                        contacts.get(j).getContactInfo();
                        return;
                    }
                }
            }
        }
        System.out.println("Contact " + name + " does not exist");
    }

    public void deleteContact() {
        System.out.println("Entery name of deleted contact");
        String contactName = scanner.nextLine();
        int lengthContacts = contacts.size();
        for (int i = 0; i < lengthContacts; i++) {
            if (contacts.get(i).getContactName().equals(contactName)) {
                int groupsLength = groups.size();
                for (int j = 0; j < groupsLength; j++) {
                    int groupContactsLength = groups.get(j).getGroupContacts().size();
                    for (int k = 0; k < groupContactsLength; k++) {
                        if (groups.get(j).getGroupContacts().get(k).getContactName().equals(contactName)) {
                            groups.get(j).getGroupContacts().remove(k);
                            contacts.remove(i);
                            System.out.println("Contact was removed");
                            return;
                        }
                    }
                }
            }
        }
        System.out.println("Contact " + contactName + " does not exist");
    }

    public void searchGroup() {
        System.out.println("Entery group name");
        String groupName = scanner.nextLine();
        System.out.println(groupName + ":\n");
        int length = groups.size();
        for (int i = 0; i < length; i++) {
            if (groups.get(i).getGroupName().equals(groupName)) {
                groups.get(i).getGroupInfo();
                return;
            }
        }
        System.out.println("Group " + groupName + " does not exist");
    }

    public void createGroup() {
        System.out.println("Entery group name");
        String groupName = scanner.nextLine();
        groups.add(new Group(groupName));
        System.out.println("Group " + groupName + " was created");
    }

    public void addInGroup() {
        System.out.println("Entery contact name");
        String contactName = scanner.nextLine();
        int contactsLength = contacts.size();
        for (int i = 0; i < contactsLength; i++) {
            if (contacts.get(i).getContactName().equals(contactName)) {
                System.out.println("Entery group name");
                String groupName = scanner.nextLine();
                int groupsLenght = groups.size();
                for (int j = 0; j < groupsLenght; j++) {
                    if (groups.get(j).getGroupName().equals(groupName)) {
                        groups.get(j).setGroupContact(contacts.get(i));
                        contacts.get(i).setContactGroups(groupName);
                        System.out.println("Contact was add to the " + groupName + " group");
                        return;
                    }
                }
                System.out.println("Group " + groupName + " does not exist");
                return;
            }
        }
        System.out.println("Contact " + contactName + "does not exist");
        return;
    }

    public void deleteFromGroup() {
        System.out.println("Entery contact name");
        String contactName = scanner.nextLine();
        int contactsLength = contacts.size();
        for (int i = 0; i < contactsLength; i++) {
            if (contacts.get(i).getContactName().equals(contactName)) {
                System.out.println("Entery group name");
                String groupName = scanner.nextLine();
                int groupsLength = groups.size();
                for (int j = 0; j < groupsLength; j++) {
                    if (groups.get(j).getGroupName().equals(groupName)) {
                        int contactGroupsLength = contacts.get(i).getContactGroups().size();
                        for (int k = 0; k < contactGroupsLength; k++) {
                            if (contacts.get(i).getContactGroups().get(k).equals(groupName)) {
                                contacts.get(i).getContactGroups().remove(k);
                                groups.get(j).removeContact(contactName);
                                System.out.println("Contact " + contactName + " removed from group " + groupName);
                                return;
                            }
                        }
                    }
                }
                System.out.println("Group " + groupName + " does not exist");
                return;
            }
        }
        System.out.println("Contact " + contactName + " does not exist");
    }

    public void checkContacts() {
        int contactsLength = contacts.size();
        for (int i = 0; i < contactsLength; i++) {
            contacts.get(i).getContactInfo();
        }
    }

    public void checkGroups() {
        int groupsLength = groups.size();
        for (int i = 0; i < groupsLength; i++) {
            groups.get(i).getGroupInfo();
        }
    }

    public void deleteGroup() {
        System.out.println("Entery name of group");
        String groupname = scanner.nextLine();
        int groupLength = groups.size();
        for (int i = 0; i < groupLength; i++) {
            if (groups.get(i).getGroupName().equals(groupname)) {
                int groupContactsLength = groups.get(i).getGroupContacts().size();
                for (int j = 0; j < groupContactsLength; j++) {
                    int contactGroupsLength = groups.get(i).getGroupContacts().get(j).getContactGroups().size();
                    for (int k = 0; k < contactGroupsLength; k++) {
                        if (groups.get(i).getGroupContacts().get(j).getContactGroups().get(k).equals(groupname)) {
                            groups.get(i).getGroupContacts().get(j).getContactGroups().remove(k);
                            groups.remove(i);
                            System.out.println("Group " + groupname + " was removed");
                            return;
                        }
                    }
                }
            }
        }
        System.out.println("Group " + groupname + " does not exist");
    }

    public void updateGroup() {
        System.out.println("Entery name of group");
        String groupname = scanner.nextLine();
        int groupLength = groups.size();
        for (int i = 0; i < groupLength; i++) {
            if (groups.get(i).getGroupName().equals(groupname)) {
                System.out.println("Entery new group name");
                String newGroupName = scanner.nextLine();
                groups.add(new Group(newGroupName));
                for (int j = 0; j < groupLength; j++) {
                    if (groups.get(j).getGroupName().equals(newGroupName)) {
                        groups.get(j).getGroupContacts().addAll(groups.get(i).getGroupContacts());
                        groups.remove(i);
                        System.out.println("Group was updated");
                        return;
                    }
                }
            }
        }
        System.out.println("Group" + groupname + " does not exist");
    }
}
