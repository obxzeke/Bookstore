package Project2;
/**
ITSC 1213 Project 2
Member class that manages the objects in Member

@author Zeke Marshall
@version Fall 2022
*/
public class Member {
        // private variables that are not accessible from outside the class
    private int index = 0;
    private String name;
    private PremiumMember premiumMember;
    private int numCDs = 0;
    private int numDVDs = 0;
    private int numBooks = 0;
    private double membBalance = 0;
    private double totalMembHasSpent = 0;

    /** default constructor that makes a member from the parameters
     * 
     * @param _index integer value for the index of the member
     * @param _name string value for the name of the member
     * @param isPremiumMemb boolean value for if the member is premium
     * @param feeDue boolean value for if a fee is due
     * @param cds integer value for how many cds are in their cart
     * @param dvds integer value for how many dvds are in their cart
     * @param books integer value for how many books are in their cart
     * @param balance double value for members balance of their cart
     */
    public Member(int _index, String _name, boolean isPremiumMemb, boolean feeDue, int cds, int dvds, int books, double balance){
        this.index = _index;
        this.name = _name;
        PremiumMember premMemb = new PremiumMember(isPremiumMemb, feeDue);
        this.premiumMember = premMemb;
        this.numCDs = cds;
        this.numDVDs = dvds;
        this.numBooks = books;
        this.membBalance = balance;
        this.totalMembHasSpent = 0;
    }
        // Getters
    /** public method to return the index of the member
     * 
     * @return returns the integer value of the index
     */
    public int getIndex(){
        return this.index;
    }

    /** public method to return the total of what member has spent at the store
     * 
     * @return returns the double value for the amount spent
     */
    public double getTotalMembHasSpent(){
        return this.totalMembHasSpent;
    }

    /** public method to return if the member is premium
     * 
     * @return returns the boolean value for if the member is premium
     */
    public boolean isMembPremium(){
        return this.premiumMember.isPremiumMemb();
    }

    /** public method to return if the fee for a member is due
     * 
     * @return returns the boolean value for if the fee is due
     */
    public boolean isFeeDue(){
        return this.premiumMember.isFeeDue();
    }

    /** public method to return the name of the member
     * 
     * @return returns a string value for name of member
     */
    public String getName(){
        return this.name;
    }

    /** public method to return the quantity of the CDs
     * 
     * @return returns the integer value for number of cds
     */
    public int getNumCDs(){
        return this.numCDs;
    }
    
    /** public method to return the quantity of the DVDs
     * 
     * @return returns the integer value for number of dvds
     */
    public int getNumDVDs(){
        return this.numDVDs;
    }

    /** public method to return the quantity of the books
     * 
     * @return returns the integer value for number of books
     */
    public int getNumBooks(){
        return this.numBooks;
    }
    
    /** public method to return the member balance
     * 
     * @return returns the double value for member balance
     */
    public double getMembBalance(){
        return membBalance;
    }

        // Setters
    /** public method to set the amount the member has spent
     * 
     * @param spent double value user has spent
     */
    public void setTotalMembHasSpent(double spent){
        this.totalMembHasSpent = spent;
    }

    /** public method to set the amount of cds the member has in their cart
     * 
     * @param _numCDs integer value of cds
     */
    public void setNumCDs(int _numCDs){
        this.numCDs = _numCDs;
    }

    /** public method to set the amount of dvds the member has in their cart
     * 
     * @param _numDVDs integer value of dvds
     */
    public void setNumDVDs(int _numDVDs){
        this.numDVDs = _numDVDs;
    }

    /** public method to set the amount of books the member has in their cart
     * 
     * @param _numBooks integer value of books
     */
    public void setNumBooks(int _numBooks){
        this.numBooks = _numBooks;
    }

    /** public method to set the amount the member has in their cart
     * 
     * @param balance double value of balance
     */
    public void setMembBalance(double balance){
        this.membBalance = balance;
    }

    /** public method to add to the amount the member has in their cart
     * 
     * @param addBalance double value of balance needed to be added
     */
    public void addToMembBalance(double addBalance){
        this.membBalance += addBalance;
    }

    /** public method to add to the amount of cds to the member's cart
     * 
     * @param cds integer value of cds needed to be added
     */
    public void addCDs(int cds){
        this.numCDs += cds;
    }

    /** public method to add to the amount of dvds to the member's cart
     * 
     * @param dvds integer value of dvds needed to be added
     */
    public void addDVDs(int dvds){
        this.numDVDs += dvds;
    }

    /** public method to add to the amount of books to the member's cart
     * 
     * @param books integer value of books needed to be added
     */
    public void addBooks(int books){
        this.numBooks += books;
    }
} // end class
