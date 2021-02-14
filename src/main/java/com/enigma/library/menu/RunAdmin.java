package com.enigma.library.menu;

import java.util.Scanner;

public class RunAdmin {



    public static void adminStart() {
        Scanner input = new Scanner(System.in);
        String userInput;
        boolean isContinue = true;
        while (isContinue) {

            System.out.println(" ");
            System.out.println("###########################################");
            System.out.println("Welcome ADMIN, please choose");
            System.out.println("1.Add new book");
            System.out.println("2.Add new category for book");
            System.out.println("3.Edit category");
            System.out.println("4.Transaction Report");
            System.out.println("5.See monthly paid tax");
            System.out.println("6.EXIT");
            System.out.print("Choose your option = ");
            userInput = input.next();

            switch (userInput) {
                case "1":
                    SubAdmin.adminAddBook();
                    isContinue = false;
                    break;
                case "2":
                    SubAdmin.adminAddCategory();
                    isContinue = false;
                    break;
                case "3":
                    SubAdmin.adminEditCategory();
                    isContinue = false;
                    break;
                case "4":
                    SubAdmin.adminSeeTransactionReport();
                    isContinue = false;
                    break;
                case "5":
                    SubAdmin.adminSeeMonthlyTax();
                    isContinue = false;
                    break;
                case "6":
                    isContinue = false;
                    break;
                default:
                    System.out.println("Input Wrong, Please choose number 1-3");
            }
        }

    }
}
