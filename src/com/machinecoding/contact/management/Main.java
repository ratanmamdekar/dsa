package com.machinecoding.contact.management;

import java.util.List;

import static com.machinecoding.contact.management.ContactUtil.contactPrinter;

public class Main {
/*
    LLD Contact Management System
    Functionality:
    Add/update contact(s)
    Search contacts (partial - prefix or complete) (Note in all searches show the total count & search results)
    Search by first name (search term is case insensitive)
    Search by last name (search term is case insensitive)
    Search by phone number
            */
    public static void main(String[] args) {
        ContactManagementSystem contactManagementSystem = new ContactManagementSystem();

        List<Contact> contactList = ContactUtil.generateContacts();

        for(Contact contact : contactList)
            contactManagementSystem.addContact(contact);

        List<Contact> contacts = contactManagementSystem.getContactsByFirstName("mona");
        contactPrinter(contacts);

        contacts = contactManagementSystem.getContactsByLastName("ratan");
        contactPrinter(contacts);


        contactManagementSystem.updateContact(contactList.get(1), Contact.builder().firstName("monal").phoneNumber(4545872970L).build());

        contacts = contactManagementSystem.getContactsByFirstName("mona");
        contactPrinter(contacts);

        contacts = contactManagementSystem.getContactsByFirstName("monal");
        contactPrinter(contacts);

        contacts = contactManagementSystem.getContactsByFirstName("dhoni");
        contactPrinter(contacts);
    }
}
