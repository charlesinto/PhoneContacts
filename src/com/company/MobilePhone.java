package com.company;

import java.util.ArrayList;

public class MobilePhone {
    ArrayList<Contact> contactList = new ArrayList<Contact>();

    public void addContact(Contact contact){
        contactList.add(contact);
    }

    public int updateContact(String des, String newDes){
        int resultCode = 0;
       if(isUnique(des)){
            int pos = getContactPos(des);
            if(pos != -1){
                if(contactList.get(pos).getPhoneNumber().trim().toLowerCase().equalsIgnoreCase(des)){
                    contactList.get(pos).setPhoneNumber(newDes);
                }else{
                    contactList.get(pos).setName(newDes);
                }
            }
            return  resultCode;
       }
       return -1;
    }
    private int getContactPos(String desc){
        int size = contactList.size();
        for(int i = 0; i < size ; i++){
            if(contactList.get(i).getName().trim().toLowerCase().equalsIgnoreCase(desc) ||
                    contactList.get(i).getPhoneNumber().trim().toLowerCase().equalsIgnoreCase(desc)){
                return i;
            }
        }
        return -1;
    }
    public int removeContact(String des){
        int resultCode = 0;
        if(isUnique(des)){
            int pos = getContactPos(des);
            if(pos != -1){
                contactList.remove(pos);
                return resultCode;
            }
        }
        return  -1;
    }
    public ArrayList<Contact> queryContact(String des){
        ArrayList<Contact> contacts = new ArrayList<Contact>();
        for(Contact contact : contactList){
            if(contact.getName().toLowerCase().trim().equalsIgnoreCase(des.trim().toLowerCase())
                || contact.getPhoneNumber().toLowerCase().trim().equalsIgnoreCase(des.trim().toLowerCase())){
                contacts.add(contact);
            }
        }
        return contacts;
    }
    private boolean isUnique(String des){
        int size = contactList.size();
        ArrayList<Contact> contacts = new ArrayList<Contact>();
        for(Contact contact : contactList){
            if(contact.getName().toLowerCase().trim().equalsIgnoreCase(des.trim().toLowerCase())
                    || contact.getPhoneNumber().toLowerCase().trim().equalsIgnoreCase(des.trim().toLowerCase())){
                contacts.add(contact);
            }
        }
        if(contacts.size() == 0 || contacts.size() > 1){
            return false;
        }
        return true;
    }
    public void  printContactList(ArrayList<Contact> contacts){
        String output = "";
        System.out.println("found: " + contacts.size());
        for(Contact contact : contacts){
            output += "Contact \n";
            output += "Name: " + contact.getName() + " Phone number " + contact.getPhoneNumber() + "\n";
            output += "-----------------";
            output += "\n";
        }
        System.out.println(output);
    }
    @Override
    public String toString() {
        String output = "";
        for(Contact contact : this.contactList){
            output += "Contact \n";
            output += "Name: " + contact.getName() + " Phone number " + contact.getPhoneNumber() + "\n";
            output += "-----------------";
            output += "\n";
        }
        return  output;
    }
}
