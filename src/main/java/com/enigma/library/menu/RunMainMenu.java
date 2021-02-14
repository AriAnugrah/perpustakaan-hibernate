package com.enigma.library.menu;


import java.util.Scanner;

public class RunMainMenu {


    public static void menuStart(){

        System.out.println("Rule library");
        System.out.println("- YOU need to become MEMBER and have ID MEMBER to RENT book");
        System.out.println("- MEMBER need to RETURN book before MEMBER can RENT book again");
        System.out.println("- MEMBER need to pay RENT PRICE and TAX after RENT a book");
        System.out.println("- MEMBER need to pay FINE(if there is any) after RETURN a book");
        System.out.println("- FINE will be generate AUTOMATICALLY by system");
        System.out.println("- MEMBER need to RESPECT and FOLLOW all RULE library");

        Scanner input = new Scanner(System.in);
        String userInput;
        boolean isContinue = true;
        while (isContinue) {

            System.out.println("Welcome to enigma library, please choose");
            System.out.println("1.Admin");
            System.out.println("2.Member");
            System.out.println("3.Exit");
            System.out.print("Choose your option = ");
            userInput = input.next();

            switch (userInput) {
                case "1":
                    RunAdmin.adminStart();
                    isContinue = false;
                    break;
                case "2":
                    RunUser.userStart();
                    isContinue = false;
                    break;
                case "3":
                    isContinue = false;
                    break;
                default:
                    System.out.println("Input Wrong, Please choose number 1-3");
            }
        }
    }
}
