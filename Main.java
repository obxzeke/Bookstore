/**
ITSC 1213 Project 2
Main class that acts as the user's interface for adding items to cart, purchasing items, adding new member, printing a report off each member, and checking inventory of items
@author Zeke Marshall
@version Fall 2022
*/
import java.util.*;
import java.lang.Math;
public class Main {
    public static void main(String[] args){
            //creating a new book store
        Bookstore store = new Bookstore();

            // creating a new scanner for user input
        Scanner sc = new Scanner(System.in);
        
            // welcome message
        System.out.println("Welcome to the Automated BookStore!");
        
            // declaring a variable for main loop
        boolean exit = false;

            // main loop
        while (exit == false) {
                // variables that will reset for each loop
            double userCartTotal = 0;
            int userCartBooks = 0;
            int userCartCDs = 0;
            int userCartDVDs = 0;
            boolean isPremiumMemb = false;
            boolean stillShopping = false;
            boolean productIsNotAvailable = false;

                // see what the user wants to do
            System.out.println("Select from one of the following options:");
            System.out.println("\t1. Add items to your cart");
            System.out.println("\t2. Pay for items in your cart");
            System.out.println("\t3. Check to see if your membership fee is due (Premium Members)");
            System.out.println("\t4. Print a detailed report about each member");
            System.out.println("\t5. Check inventory and see total inventory");
            System.out.println("\t6. Add inventory");
            System.out.println("\t7. Sort product list by price");
            System.out.println("\t8. Exit");

                // recieves user input then proccessing what user wants to do
            int userInput = sc.nextInt();
                
            switch (userInput){     // main switch

                    // adding items to cart
                case 1:
                        // Variables for loops
                    stillShopping = true;
                    productIsNotAvailable = true;
                        // loop so user can add as many items into their cart
                    while (stillShopping == true){
                            // loop for where user can select a new item if the other item is out of stock
                        while (productIsNotAvailable == true){
                            System.out.println("What would you like to buy?");
                            System.out.println("\t1. Book");
                            System.out.println("\t2. DVD");
                            System.out.println("\t3. CD");
                            int type = sc.nextInt();
                            
                            switch(type){

                                    // asks which book they would like to purchase and displays a list of them
                                case 1:
                                    System.out.println("Which book would you like to purchase?");
                                    store.printBookList();
                                    int userBook = sc.nextInt();
                                            // if book is available then the book is added to cart and loop breaks
                                        if (store.isBookAvaliable(userBook)){
                                            userCartTotal += store.makeBookPurchase(userBook);
                                            userCartBooks++;
                                            productIsNotAvailable = false;
                                        }
                                        else {
                                            System.out.println("That book is not available, try something else.");
                                        }
                                    break;

                                    // asks which dvd they would like to purchase and displays a list of them
                                case 2:
                                    System.out.println("Which DVD would you like to purchase?");
                                    store.printDVDList();
                                    int userDVD = sc.nextInt();
                                        // if dvd is available then the dvd is added to cart and loop breaks
                                    if (store.isDVDAvaliable(userDVD)){
                                        userCartTotal += store.makeDVDPurchase(userDVD);
                                        userCartDVDs++;
                                        productIsNotAvailable = false;
                                    }
                                    else {
                                        System.out.println("That DVD is not available, try something else.");
                                    }
                                    break;

                                    // asks which cd they would like to purchase and displays a list of them
                                case 3:
                                    System.out.println("Which CD would you like to purchase?");
                                    store.printCDList();
                                    int userCD = sc.nextInt();
                                        // if cd is available then the cd is added to cart and loop breaks
                                    if (store.isCDAvaliable(userCD)){
                                        userCartTotal += store.makeCDPurchase(userCD);
                                        userCartCDs++;
                                        productIsNotAvailable = false;
                                    }
                                    else {
                                        System.out.println("That CD is not available, try something else.");
                                    }
                                    break;
                            } // end of type switch
                        } // productIsNotAvaliable loop

                        System.out.println("Are you finished shopping?");
                        System.out.println("\t1. Yes");
                        System.out.println("\t2. No");
                        int finishedShopping = sc.nextInt();
                        
                        switch (finishedShopping){

                                // runs if user is finished shopping
                                // asks which member is shopping and can add a new member 
                            case 1:
                                    // rounds to two decimal points
                                userCartTotal = Math.round(userCartTotal * 100.0) / 100.0;

                                System.out.println("Which member is adding to their cart?");
                                store.printMembers();
                                int memberID = sc.nextInt();
                                
                                if (store.isNewMember(memberID)){
                                    System.out.println("What is your name?");
                                    String name = sc.next();
                                    System.out.println("Would you like to register as a free-tier or premium member?");
                                    System.out.println("\t1. Free-tier");
                                    System.out.println("\t2. Premium");
                                    int tierMember = sc.nextInt();
                                    
                                    switch (tierMember){
                                        case 1:
                                            isPremiumMemb = false;
                                            break;
                                        case 2:
                                            isPremiumMemb = true;
                                            break;
                                    }
                                        // makes a new member
                                    store.addMember(store.getMemberIndexCounter(), name, isPremiumMemb, true, userCartCDs, userCartDVDs, userCartBooks, userCartTotal);
                                    System.out.println("Thanks for signing up " + name + "!");
                                    System.out.println("Your cart total is $" + userCartTotal + "\n");
                                }
                                else{
                                    store.putItemsInCart(memberID, userCartCDs, userCartDVDs, userCartBooks, userCartTotal);
                                    System.out.println("Your cart total is $" + userCartTotal + "\n");
                                }
                                stillShopping = false;
                                break;  // breaks from case 1 of finished shopping switch
                                
                                // runs if user is not finished shopping
                            case 2:
                                productIsNotAvailable = true;
                                break;
                        } //Switch finishedShopping
                    } // stillShopping Loop
                            break; // breaks out of case 1 for main switch
                
                    // pay for items in members cart
                case 2:
                    System.out.println("Which member is making this purchase?");
                    store.printMembers();
                    int memberID = sc.nextInt();
                        
                        // if member is premium then they get a 20% discount
                    if (store.isMemberPremium(memberID)){
                        System.out.println("Your total is $" + store.getMemberBalance(memberID));
                        System.out.println("Since you are a premium member you recieve a 20% discount!");
                        double spent = store.getMemberBalance(memberID) * .8;
                            //rounds to two decimal points
                        spent *= 100;
                        spent = (int)spent;
                        spent /= 100;
                        
                        System.out.println("\nThank you for your purchase of $" + spent);
                        System.out.println(store.purchaseMessage(memberID));
                        store.memberPurchase(spent, memberID);
                    }
                    else{
                        System.out.println("Your total is $" + store.getMemberBalance(memberID));
                        System.out.println("\nThank you for your purchase of $" + store.getMemberBalance(memberID));
                        System.out.println(store.purchaseMessage(memberID));
                        store.memberPurchase(store.getMemberBalance(memberID), memberID);
                    }
                    break;
                    
                    // checks to see if premium fee is due
                case 3:
                    System.out.println("Which member would you like to check?");
                    store.printMembers();
                    int userID = sc.nextInt();
                        if (store.isMemberPremium(userID)){
                            if (store.isFeeDue(userID)){
                                System.out.println("Your fee is due.");
                            }
                            else {
                                System.out.println("You fee is not due for this month.");
                            }
                        }
                        else {
                            System.out.println("Member is not a premium member.");
                        }
                    break;
                    
                    // calls method in bookstore to print a report of all the members
                case 4:
                    store.printDetailedReport();
                    break;

                    // prints a inventory report of the items
                case 5:
                    store.printProductList();
                    break; 
                        
                    // Adds inventory by asking the index of product and the quantity of the amount they want to add
                case 6:
                    System.out.println("Select which product would you like to add inventory to.");
                    store.printProductList();
                    int userIndex = sc.nextInt();
                    System.out.println("Enter how many of the item you are adding.");
                    int userInventory = sc.nextInt();
                    store.restockProduct(userIndex, userInventory);
                    break;

                    // Sorts product list by price (lowest first)
                case 7:
                    store.sortList();
                    break;

                    // exits program
                case 8:
                    exit = true;
                    break;

        } // Switch userInput
        } // Main Loop
    } // Main Method
} // Main class
