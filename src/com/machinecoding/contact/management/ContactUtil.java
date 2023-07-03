package com.machinecoding.contact.management;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ContactUtil {

    public static List<Contact> generateContacts(){
        List<Contact> contactList = new ArrayList<>();

        contactList.add(createContact("Ratan","Mamdekar",98709871234L));
        contactList.add(createContact("Mona","Lisa",3544871234L));
        contactList.add(createContact("Cr7","Ronaldo",12679871234L));
        contactList.add(createContact("leo","messi",46589871234L));
        contactList.add(createContact("DHONI","mahi",7899871234L));
        contactList.add(createContact("dhoni","csk",4289871234L));
        contactList.add(createContact("Dhoni","pune",6808571234L));
        contactList.add(createContact("sachin","Tendulkar",6300987234L));
        UUID uuid = UUID.randomUUID();
        return contactList;
    }

    private static Contact createContact(String firstName, String lastName, long phoneNumber) {
        return Contact.builder()
                .firstName(firstName)
                .lastName(lastName)
                .phoneNumber(phoneNumber)
                .build();
    }

    public static void contactPrinter(List<Contact> contactList){
        System.out.println("found " + contactList.size() + " contacts");
        for (Contact contact : contactList)
            System.out.println(contact);
        System.out.println("");
    }
}
