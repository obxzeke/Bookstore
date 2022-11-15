import java.util.*;
/**
ITSC 1213 Project 2
Book store class that manages member purchases, adding to carts, display messages, and getters from other classes

@author Zeke Marshall
@version Fall 2022
*/
public class Bookstore implements BookStoreSpecification{
        // private variables and arrayLists that are not accessible from outside the class
    private ArrayList<Member> memberList = new ArrayList<>();
    private ArrayList<Product> productList = new ArrayList<>();
    private int memberIndexCounter = 0;

        // default constructor that makes three default members and three default books, cds, and dvds
    public Bookstore(){
        Member memb1 = new Member(1, "Bob", true, false, 2, 3, 1, 45.87);
        memberList.add(memb1);
        Member memb2 = new Member(2, "Jill", false, false, 0, 0, 0, 0);
        memberList.add(memb2);
        Member memb3 = new Member(3, "Zeke", true, true, 1, 2, 3, 25.67);
        memberList.add(memb3);
        memberIndexCounter = 4;

        Book harryPotter = new Book(1, "Harry Potter and the Sorcerer's Stone - J.K. Rowling", 12.99, 1);
        productList.add(harryPotter);
        Book goosebumps = new Book(2, "Goosebumps Say Cheese - R.L. Stine", 6.99, 3);
        productList.add(goosebumps);
        Book hatchet = new Book(3, "Hatchet - Gary Paulsen", 9.99, 3);
        productList.add(hatchet);

        CD Juice = new CD(4, "Fighting Demons - Juice WRLD", 15.99, 3);
        productList.add(Juice);
        CD nirvana = new CD(5, "Nevermind - Nirvana", 12.99, 3);
        productList.add(nirvana);
        CD ski = new CD(6, "Stokeley - Ski Mask the Slump God", 18.99, 3);
        productList.add(ski);

        DVD lionKing = new DVD(7, "The Lion King - Disney", 8.99, 3);
        productList.add(lionKing);
        DVD avengers = new DVD(8, "Avengers Endgame - Marvel", 12.99, 3);
        productList.add(avengers);
        DVD starWars = new DVD(9, "Star Wars: A New Hope - George Lucas", 7.99, 3);
        productList.add(starWars);
    }

        // Getters
    /** public method to return the index of the next member index
     * 
     * @return returns the integer value for next member index
     */
    public int getMemberIndexCounter(){
        return this.memberIndexCounter;
    }

    /** public method to return if the member is a premium member by looping throught the member list until the indexes match
     * 
     * @param userIndex takes the index of the user it wants to find
     * @return returns a boolean value for whether the desired member index is premium
     */
    public boolean isMemberPremium(int userIndex){
        for (Member memb : memberList){
            if (memb.getIndex() == userIndex){
                if (memb.isMembPremium()){
                    return true;
                }
            }
        }
        return false;
    }
    
    /** public method to return if the premium member fee is due by looping throught the member list until the indexes match
     * 
     * @param userIndex takes the index of the user it wants to find
     * @return returns a boolean value for whether the desired member's fee is due
     */
    public boolean isFeeDue(int userIndex){
        for (Member memb : memberList){
            if (memb.getIndex() == userIndex){
                if (memb.isFeeDue()){
                    return true;
                }
            }
        }
        return false;
    }

    /** public method to return a members cart balance by looping throught the member list until the indexes match
     * 
     * @param userIndex takes the index of the user it wants to find
     * @return returns a double value for the members balance
     */
    public double getMemberBalance(int userIndex){
        for (Member memb : memberList){
            if (memb.getIndex() == userIndex){
                return memb.getMembBalance();
            }
        }
        return -1;
    }

    /** public method to return if a cd is avaliable by looping through the cd list and checking the quantity is above 0
     * 
     * @param cdIndex takes the index of the cd it wants to find
     * @return returns a boolean value for whether the cd is avaliable
     */
    public boolean isCDAvaliable(int cdIndex){
        for (Product cds : productList){
            if (cds instanceof CD){
                if (cds.getIndex() == cdIndex){
                    if (cds.getQuantity() > 0){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /** public method to return if a dvd is avaliable by looping through the dvd list and checking the quantity is above 0
     * 
     * @param dvdIndex takes the index of the dvd it wants to find
     * @return returns a boolean value for whether the dvd is avaliable
     */
    public boolean isDVDAvaliable(int dvdIndex){
        for (Product dvds : productList){
            if (dvds instanceof DVD){
                if (dvds.getIndex() == dvdIndex){
                    if (dvds.getQuantity() > 0){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /** public method to return if a book is avaliable by looping through the book list and checking the quantity is above 0
     * 
     * @param bookIndex takes the index of the book it wants to find
     * @return returns a boolean value for whether the book is avaliable
     */
    public boolean isBookAvaliable(int bookIndex){
        for (Product books : productList){
            if (books instanceof CD){
                if (books.getIndex() == bookIndex){
                    if (books.getQuantity() > 0){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /** public method to return if the user index entered is in the loop by looping throught the member list until the indexes match or don't
     * 
     * @param userIndex takes the index of the user it wants to find
     * @return returns a boolean value for if the member is new or not
     */
    public boolean isNewMember(int userIndex){
        for (Member memb : memberList){
            if (memb.getIndex() == userIndex){
                return false;
            }
        }
        return true;
    }

    /** public method to return the price of a book by looping through the product list until the indexes match
     * 
     * @param bookIndex integer value of the index of the desired book
     * @return the double value of price of the book
     */
    public double makeBookPurchase(int bookIndex){
        for (Product books : productList){
            if (books instanceof Book){
                if (books.getIndex() == bookIndex){
                    books.purchased();
                    return books.getPrice();
                }
            }
        }
        return 0;
    }

    /** public method to return the price of a cd by looping through the product list until the indexes match
     * 
     * @param cdIndex integer value of the index of the desired cd
     * @return the double value of price of the cd
     */
    public double makeCDPurchase(int cdIndex){
        for (Product cds : productList){
            if (cds instanceof CD){
                if (cds.getIndex() == cdIndex){
                    cds.purchased();
                    return cds.getPrice();
                }
            }
        }
        return 0;
    }

    /** public method to return the price of a dvd by looping through the product list until the indexes match
     * 
     * @param dvdIndex integer value of the index of the desired dvd
     * @return the double value of price of the dvd
     */
    public double makeDVDPurchase(int dvdIndex){
        for (Product dvds : productList){
            if (dvds instanceof DVD){
                if (dvds.getIndex() == dvdIndex){
                    dvds.purchased();
                    return dvds.getPrice();
                }
            }
        }
        return 0;
    }

        // Purchase Methods
    /** public method to make a purchase by looping through member list until the index matches then setting values in the member object
     * 
     * @param amount double value for the balance in a member's cart
     * @param userIndex integer value for the member's index
     */
    public void memberPurchase(double amount, int userIndex){
        for (Member memb : memberList){
            if (memb.getIndex() == userIndex){
                memb.setMembBalance(0);
                memb.setTotalMembHasSpent(amount);
                memb.setNumCDs(0);
                memb.setNumDVDs(0);
                memb.setNumBooks(0);
            }
        }
    }

    /** public method to add items the member wants to purchase into the members cart by looping through member list until the indexes match then using set methods to add the items
     * 
     * @param userIndex integer value for the member's index
     * @param cds integer value for the cds wanted to be added to cart
     * @param dvds integer value for the dvds wanted to be added to cart
     * @param books integer value for the books wanted to be added to cart
     * @param total double value for the amount of money wanted to be added to a member's balance
     */
    public void putItemsInCart(int userIndex, int cds, int dvds, int books, double total){
        for (Member memb : memberList){
            if (memb.getIndex() == userIndex){
                memb.addCDs(cds);
                memb.addDVDs(dvds);
                memb.addBooks(books);
                memb.addToMembBalance(total);
                break;
            }
        }
    }

        // Print Methods
    /** public method to display what the member has purchased by displaying the cds, dvds, and books in a member's cart
     * 
     * @param userIndex integer value of the member's index
     * @return returns a string that displays the items purchased and returns with no user found if the index doesn't match any index in member list
     */
    public String purchaseMessage(int userIndex){
        for (Member memb : memberList){
            if (memb.getIndex() == userIndex){
                return "You purchased:\n\t" + memb.getNumCDs() + " CD(s)\n\t" + memb.getNumDVDs() + " DVD(s)\n\t" + memb.getNumBooks() + " Book(s)";
            }
        }
        return "User not found";
    }

    // public method to print the objects in the product list
    public void printProductList(){
        for (Product item : productList){
            System.out.println(item);
        }
        System.out.println();
    }

    // prints the objects in product list that are book objects
    public void printBookList(){
        for (Product books : productList){
            if (books instanceof Book){
                System.out.println(books);
            }
        }
    }

    // prints the objects in product list that are cd objects
    public void printCDList(){
        for (Product cds : productList){
            if (cds instanceof CD){
                System.out.println(cds);
            }
        }
    }

    // prints the objects in product list that are dvd objects
    public void printDVDList(){
        for (Product dvds : productList){
            if (dvds instanceof DVD){
                System.out.println(dvds);
            }
        }
    }

    // prints the objects in member list with looping and an option to register a new member
    public void printMembers(){
        for (Member names : memberList){
            System.out.println("\t" + names.getIndex() + ". " + names.getName());
        }
        System.out.println("\t" + (memberIndexCounter) + ". Register a new member");
    }

    // prints a detailed report of every member in member list with looping
    public void printDetailedReport(){
        for (Member names : memberList){
            System.out.println("Member " + names.getIndex() + ":");
            System.out.println("\tName: " + names.getName());
            System.out.println("\tPremium Member: " + names.isMembPremium());
            System.out.println("\tFee due: " + names.isFeeDue());
            System.out.println("\tCDs in cart: " + names.getNumCDs());
            System.out.println("\tDVDs in cart: " + names.getNumDVDs());
            System.out.println("\tBooks in cart: " + names.getNumBooks());
            System.out.println("\tCart Balance $" + names.getMembBalance());
            System.out.println("\tTotal spent at store: $" + names.getTotalMembHasSpent() + "\n");
        }
    }

        // Adders
    /** public method that adds a new member to memberList 
     * 
     * @param _index integer value of the index of the member
     * @param name String value of the name of the member
     * @param isPremiumMemb boolean value of if the member is premium
     * @param feeDue boolean value of if the premium fee is due
     * @param cds integer value of the cds wanting to be added to cart
     * @param dvds integer value of the dvds wanting to be added to cart
     * @param books integer value of the books wanting to be added to cart
     * @param balance double value of total of items being added to cart
     */
    public void addMember(int userIndex, String name, boolean isPremiumMemb, boolean feeDue, int cds, int dvds, int books, double balance){
        Member newMember = new Member(userIndex, name, isPremiumMemb, feeDue, cds, dvds, books, balance);
        memberList.add(newMember);
        memberIndexCounter++;
    }
    
    /** public method to add inventory to a product
     * 
     * @param index the index of the product the user wants to add to
     * @param quantity the amount of product the user wants to add
     */
    public void restockProduct(int index, int quantity){
        for (Product p : productList){
            if (p.getIndex() == index){
                p.addInventory(quantity);
                System.out.println("You added " + quantity + " items to " + p.getTitle());
                System.out.println("There is a total of " + inventoryValue() + "products in the store.");
            }
        }
    }

    /** public method to add up all the inventory of each product in the store
     * 
     *  @return returns the total amount of inventory in the store
     */
    public double inventoryValue(){
        double inventoryTotal = 0;
        for (Product p : productList){
            inventoryTotal += p.getQuantity();
        }
        return inventoryTotal;
    }

    /**
     *  public method to sort product list by price (lowest first)
     */
    public void sortList(){
        Collections.sort(productList);
        printProductList();
    }
} // end class
