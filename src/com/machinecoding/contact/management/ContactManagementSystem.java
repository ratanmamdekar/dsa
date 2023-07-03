package com.machinecoding.contact.management;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class ContactManagementSystem {
    private List<Contact> contactList;
    private Map<String,List<Contact>> firstNameToContactMap;
    private Map<String,List<Contact>> lastNameToContactMap;
    private Map<Long,Contact> phoneNumberToContactMap;
    private ContactManagementService contactManagementService;

    ContactManagementSystem(){
        contactList=new ArrayList<>();
        firstNameToContactMap = new HashMap<>();
        lastNameToContactMap = new HashMap<>();
        phoneNumberToContactMap = new HashMap<>();
        contactManagementService = new ContactManagementService();
    }

    public void addContact(Contact contact){
        contactManagementService.addContact(this,contact);
    }

    public void updateContact(Contact oldContact, Contact newContact){
        System.out.println("Updating contact "+oldContact +" with "+newContact);
        contactManagementService.updateContact(this,oldContact,newContact);
    }

    public List<Contact> getContactsByFirstName(String firstName){
        System.out.print("Searching for "+firstName+"... ");
        return Optional.ofNullable(firstNameToContactMap.get(firstName.toLowerCase()))
                .orElse(Collections.emptyList());
    }

    public List<Contact> getContactsByLastName(String lastName){
        System.out.print("Searching for "+lastName+"... ");
        return Optional.ofNullable(lastNameToContactMap.get(lastName.toLowerCase()))
                .orElse(Collections.emptyList());
    }

    public Contact getContactByPhoneNumber(Long phoneNumber){
        System.out.print("Searching for "+phoneNumber+"... ");
        return phoneNumberToContactMap.get(phoneNumber);
    }

    public List<Contact> getAllContacts(){
        List<Contact> contactList = new ArrayList<>();
        for(String name : firstNameToContactMap.keySet()){
            contactList.addAll(firstNameToContactMap.get(name));
        }
        return contactList;
    }

}
