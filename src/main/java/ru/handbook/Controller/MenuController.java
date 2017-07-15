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
        messenger.nameRequest("contact");
        String name = scanner.nextLine();
        int length = contacts.size();
        for (int i = 0; i < length; i++) {
            if (contacts.get(i).getContactName().equals(name)) {
                contacts.get(i).getContactInfo();
                return;
            }
        }
        messenger.nameNonexistent(name);
    }

    public void createContact() {
        messenger.nameRequest("contact");
        String name = scanner.nextLine();
        if (!name.equals("")) {
            int contactsLength = contacts.size();
            for (int i = 0; i < contactsLength; i++) {
                if (contacts.get(i).getContactName().equals(name)) {
                    messenger.nameIsBusy(name);
                    return;
                }
            }
            contacts.add(new Contact(name));
            messenger.createSuccess(name);
        } else messenger.emptyName(name);
    }

    public void updateContact() {
        messenger.nameRequest("contact");
        String name = scanner.nextLine();
        int length = contacts.size();
        for (int i = 0; i < length; i++) {
            if (contacts.get(i).getContactName().equals(name)) {
                System.out.println("Would you update name? y/n");
                String yn = scanner.nextLine();
                String newName = "";
                if (yn.equals("y")) {
                    messenger.newNameRequest("contact");
                    newName = scanner.nextLine();
                    if (!newName.equals("")) {
                        for (int j = 0; j < length; j++) {
                            if (!contacts.get(j).getContactName().equals(newName)) {
                                contacts.get(j).setContactName(newName);
                            } else {
                                messenger.nameIsBusy(newName);
                                return;
                            }
                        }
                    } else {
                        messenger.emptyName(newName);
                        return;
                    }
                }
                messenger.newDataRequest("telephone");
                String quest = scanner.nextLine();
                contacts.get(i).setTelephone(quest);
                messenger.newDataRequest("skype");
                quest = scanner.nextLine();
                contacts.get(i).setSkype(quest);
                messenger.newDataRequest("mail");
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
        messenger.nameNonexistent(name);
    }

    public void deleteContact() {
        messenger.nameRequest("contact");
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
                            messenger.removeSuccess(contactName);
                            return;
                        }
                    }
                }
            }
        }
        messenger.nameNonexistent(contactName);
    }

    public void searchGroup() {
        messenger.nameRequest("group");
        String groupName = scanner.nextLine();
        System.out.println(groupName + ":\n");
        int length = groups.size();
        for (int i = 0; i < length; i++) {
            if (groups.get(i).getGroupName().equals(groupName)) {
                groups.get(i).getGroupInfo();
                return;
            }
        }
        messenger.nameNonexistent(groupName);
    }

    public void createGroup() {
        messenger.nameRequest("group");
        String groupName = scanner.nextLine();
        if (!groupName.equals("")) {
            int groupsLength = groups.size();
            for (int i = 0; i < groupsLength; i++) {
                if (groups.get(i).getGroupName().equals(groupName)) {
                    messenger.nameIsBusy(groupName);
                    return;
                }
            }
            groups.add(new Group(groupName));
            messenger.createSuccess(groupName);
        } else {
            messenger.emptyName(groupName);
        }
    }

    public void addInGroup() {
        messenger.nameRequest("contact");
        String contactName = scanner.nextLine();
        int contactsLength = contacts.size();
        for (int i = 0; i < contactsLength; i++) {
            if (contacts.get(i).getContactName().equals(contactName)) {
                messenger.nameRequest("group");
                String groupName = scanner.nextLine();
                int groupsLenght = groups.size();
                for (int j = 0; j < groupsLenght; j++) {
                    if (groups.get(j).getGroupName().equals(groupName)) {
                        groups.get(j).setGroupContact(contacts.get(i));
                        contacts.get(i).setContactGroups(groupName);
                        messenger.addGroupSuccess(contactName, groupName);
                        return;
                    }
                }
                messenger.nameNonexistent(groupName);
                return;
            }
        }
        messenger.nameNonexistent(contactName);
        return;
    }

    public void deleteFromGroup() {
        messenger.nameRequest("contact");
        String contactName = scanner.nextLine();
        int contactsLength = contacts.size();
        for (int i = 0; i < contactsLength; i++) {
            if (contacts.get(i).getContactName().equals(contactName)) {
                messenger.nameRequest("group");
                String groupName = scanner.nextLine();
                int groupsLength = groups.size();
                for (int j = 0; j < groupsLength; j++) {
                    if (groups.get(j).getGroupName().equals(groupName)) {
                        int contactGroupsLength = contacts.get(i).getContactGroups().size();
                        for (int k = 0; k < contactGroupsLength; k++) {
                            if (contacts.get(i).getContactGroups().get(k).equals(groupName)) {
                                contacts.get(i).getContactGroups().remove(k);
                                groups.get(j).removeContact(contactName);
                                messenger.removeGroupSuccess(contactName, groupName);
                                return;
                            }
                        }
                    }
                }
                messenger.nameNonexistent(groupName);
                return;
            }
        }
        messenger.nameNonexistent(contactName);
    }

    public void checkContacts() {
        int contactsLength = contacts.size();
        if (contacts != null) {
            for (int i = 0; i < contactsLength; i++) {
                contacts.get(i).getContactInfo();
            }
        } else messenger.emptyList("Contact");
    }

    public void checkGroups() {
        int groupsLength = groups.size();
        if (groups != null) {
            for (int i = 0; i < groupsLength; i++) {
                groups.get(i).getGroupInfo();
            }
        } else messenger.emptyList("Group");
    }

    public void deleteGroup() {
        messenger.nameRequest("group");
        String groupName = scanner.nextLine();
        int groupLength = groups.size();
        for (int i = 0; i < groupLength; i++) {
            if (groups.get(i).getGroupName().equals(groupName)) {
                int groupContactsLength = groups.get(i).getGroupContacts().size();
                for (int j = 0; j < groupContactsLength; j++) {
                    int contactGroupsLength = groups.get(i).getGroupContacts().get(j).getContactGroups().size();
                    for (int k = 0; k < contactGroupsLength; k++) {
                        if (groups.get(i).getGroupContacts().get(j).getContactGroups().get(k).equals(groupName)) {
                            groups.get(i).getGroupContacts().get(j).getContactGroups().remove(k);
                            groups.remove(i);
                            messenger.removeSuccess(groupName);
                            return;
                        }
                    }
                }
            }
        }
        messenger.nameNonexistent(groupName);
    }

    public void updateGroup() {
        messenger.nameRequest("group");
        String groupName = scanner.nextLine();
        int groupLength = groups.size();
        for (int i = 0; i < groupLength; i++) {
            if (groups.get(i).getGroupName().equals(groupName)) {
                messenger.newNameRequest("contact");
                String newGroupName = scanner.nextLine();
                groups.add(new Group(newGroupName));
                for (int j = 0; j < groupLength; j++) {
                    if (groups.get(j).getGroupName().equals(newGroupName)) {
                        groups.get(j).getGroupContacts().addAll(groups.get(i).getGroupContacts());
                        groups.remove(i);
                        messenger.updateSuccess(groupName);
                        return;
                    }
                }
            }
        }
        messenger.nameNonexistent(groupName);
    }
}
