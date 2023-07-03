package com.machinecoding.contact.management;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ContactManagementService {

    public void addContact(ContactManagementSystem cms, Contact contact){
        cms.getContactList().add(contact);
        addInNameMap(cms.getFirstNameToContactMap(),contact.getFirstName(),contact);
        addInNameMap(cms.getLastNameToContactMap(),contact.getLastName(),contact);
        cms.getPhoneNumberToContactMap().put(contact.getPhoneNumber(), contact);
    }

    private void addInNameMap(Map<String, List<Contact>> nameToContactMap, String name, Contact contact) {
        if(!nameToContactMap.containsKey(name.toLowerCase()))
            nameToContactMap.put(name.toLowerCase(), new ArrayList<>());
        nameToContactMap.get(name.toLowerCase()).add(contact);
    }

    public void updateContact(ContactManagementSystem cms, Contact oldContact, Contact newContact){
        if(noUpdateRequired(oldContact,newContact))
            return;
        if(newContact.getFirstName()==null)
            newContact.setFirstName(oldContact.getFirstName());
        if(newContact.getLastName()==null)
            newContact.setLastName(oldContact.getLastName());
        if(newContact.getPhoneNumber()==null)
            newContact.setPhoneNumber(oldContact.getPhoneNumber());

        addContact(cms,newContact);
        deleteContact(cms,oldContact);
    }

    private void deleteContact(ContactManagementSystem cms, Contact contact) {
        cms.getFirstNameToContactMap().get(contact.getFirstName().toLowerCase()).remove(contact);
        cms.getLastNameToContactMap().get(contact.getLastName().toLowerCase()).remove(contact);
        cms.getPhoneNumberToContactMap().remove(contact.getPhoneNumber());
    }

    private boolean noUpdateRequired(Contact oldContact, Contact newContact) {
        boolean firstNameNotChanged = newContact.getFirstName() ==null || newContact.getFirstName().equals(oldContact.getFirstName());
        boolean lastNameNotChanged = newContact.getLastName() ==null || newContact.getLastName().equals(oldContact.getLastName());
        boolean phoneNumberNotChanged = newContact.getPhoneNumber() ==null || newContact.getPhoneNumber().equals(oldContact.getPhoneNumber());

        return  firstNameNotChanged && lastNameNotChanged && phoneNumberNotChanged;
    }

}
