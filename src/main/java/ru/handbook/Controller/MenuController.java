package ru.handbook.Controller;

import ru.handbook.core.Messenger;
import ru.handbook.model.Contact;
import ru.handbook.model.Group;

import static ru.handbook.core.Main.contacts;
import static ru.handbook.core.Main.groups;
import static ru.handbook.core.Main.scanner;

/**
 * Created by operator1 on 14.07.2017.
 */
public class MenuController {
    Messenger messenger = new Messenger();
    public void searchContact() {
        messenger.contactNameRequest();
        String name = scanner.nextLine();
        int length = contacts.size();
        for (int i = 0; i < length; i++) {
            if (contacts.get(i).getContactName().equals(name)) {
                contacts.get(i).getContactInfo();
                return;
            }
        }
        messenger.contactNameNonexistent(name);
    }

    public void createContact() {
        messenger.contactNameRequest();
        String name = scanner.nextLine();
        if (!name.equals("")) {
            int contactsLength = contacts.size();
            for (int i = 0; i < contactsLength; i++) {
                if (contacts.get(i).getContactName().equals(name)) {
                    System.out.println("This is name is busy");
                    return;
                }
            }
            contacts.add(new Contact(name));
            System.out.println(name + " was created");
        } else System.out.println("Name can not be empty");
    }

    public void updateContact() {
        messenger.contactNameRequest();
        String name = scanner.nextLine();
        int length = contacts.size();
        for (int i = 0; i < length; i++) {
            if (contacts.get(i).getContactName().equals(name)) {
                System.out.println("Would you update name? y/n");
                String yn = scanner.nextLine();
                String newName = "";
                if (yn.equals("y")) {
                    System.out.println("Entery new name");
                     newName= scanner.nextLine();
                    for (int j = 0; j < length; j++) {
                        if (!contacts.get(j).getContactName().equals(newName)) {
                            contacts.get(j).setContactName(newName);
                        } else System.out.println("This name is busy");
                    }
                }
                System.out.println("Entery new telephone");
                String quest = scanner.nextLine();
                contacts.get(i).setTelephone(quest);
                System.out.println("Entery new skype");
                quest = scanner.nextLine();
                contacts.get(i).setSkype(quest);
                System.out.println("Entery new mail");
                quest = scanner.nextLine();
                contacts.get(i).setMail(quest);
                if (!newName.equals("")) {
                    for (int j = 0; j < length; j++) {
                        if (contacts.get(j).getContactName().equals(newName)) {
                            contacts.get(j).getContactInfo();
                            return;
                        }
                    }
                }
                for (int j = 0; j < length; j++) {
                    if (contacts.get(j).getContactName().equals(name)) {
                        contacts.get(j).getContactInfo();
                        return;
                    }
                }
            }
        }
        messenger.contactNameNonexistent(name);
    }

    public void deleteContact() {
        messenger.contactNameRequest();
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
        messenger.contactNameNonexistent(contactName);
    }

    public void searchGroup() {
        messenger.groupNameRequest();
        String groupName = scanner.nextLine();
        System.out.println(groupName + ":\n");
        int length = groups.size();
        for (int i = 0; i < length; i++) {
            if (groups.get(i).getGroupName().equals(groupName)) {
                groups.get(i).getGroupInfo();
                return;
            }
        }
        messenger.groupNameRequest();
    }

    public void createGroup() {
        messenger.groupNameRequest();
        String groupName = scanner.nextLine();
        if (!groupName.equals("")) {
            groups.add(new Group(groupName));
            System.out.println("Group " + groupName + " was created");
        } else System.out.println("Name can not be empty");
    }

    public void addInGroup() {
        messenger.contactNameRequest();
        String contactName = scanner.nextLine();
        int contactsLength = contacts.size();
        for (int i = 0; i < contactsLength; i++) {
            if (contacts.get(i).getContactName().equals(contactName)) {
                messenger.groupNameRequest();
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
                messenger.groupNameNonexistent(groupName);
                return;
            }
        }
        messenger.contactNameNonexistent(contactName);
        return;
    }

    public void deleteFromGroup() {
        messenger.contactNameRequest();
        String contactName = scanner.nextLine();
        int contactsLength = contacts.size();
        for (int i = 0; i < contactsLength; i++) {
            if (contacts.get(i).getContactName().equals(contactName)) {
                messenger.groupNameRequest();
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
                messenger.groupNameNonexistent(groupName);
                return;
            }
        }
        messenger.contactNameNonexistent(contactName);
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
        messenger.groupNameRequest();
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
        messenger.groupNameRequest();
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
