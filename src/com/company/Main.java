package com.company;

import java.util.Scanner;

public class Main {
    private static  MobilePhone phone = new MobilePhone();
    public static void main(String[] args) {
	// write your code here
        startApp();
    }
    public static void  startApp(){
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        printInstructions();
        while(!quit){
            int response = scanner.nextInt();
            switch (response){
                case 1:
                    printInstructions();
                    break;
                case 2:
                    addContact();
                    break;
                case 3:
                    modfiyContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    queryContactList();
                     break;
                case 6:
                    System.out.println(phone);
                    break;
                case 7:
                    quit = true;
            }
        }
    }

    public static void printInstructions(){
        String output = "1 - for instructions \n 2- Add contact \n";
        output += " 3- Update Contact \n 4- remove contact \n 5- query contact list \n " +
               "6- print contact list \n 7- quit";
        System.out.println(output);
    }

    public static void addContact(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name");
        String name = scanner.next();
        System.out.println("Enter phone number");
        String phoneNumber = scanner.next();
        phone.addContact(new Contact(name, phoneNumber));
        printInstructions();
    }

    public static  void removeContact(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter contact name or phone number to remove");
        String desc = scanner.next();
        int returnCode = phone.removeContact(desc.trim());
        if(returnCode == 0){
            System.out.println("Contact updated successfully");
        }else{
            System.out.println("error carrying out operation");
        }
        printInstructions();
    }

    public static  void queryContactList(){
        Scanner scanner = new Scanner(System.in);
        String desc = "";
        System.out.println("Enter contact name or phone number");
        desc = scanner.next();
        phone.printContactList(phone.queryContact(desc.trim()));
        System.out.println("\n");
        printInstructions();
    }

    public static  void modfiyContact(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter old contact name or phone number");
        String oldInfo = scanner.next();
        System.out.println("Enter new contact name or phone number");
        String newInfo = scanner.next();
        int returnCode = phone.updateContact(oldInfo.trim(), newInfo.trim());
        if(returnCode == 0){
            System.out.println("Contact updated successfully");
        }else{
            System.out.println("error carrying out operation");
        }
        printInstructions();
    }
}
