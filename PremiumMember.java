package Project2;
/**
ITSC 1213 Project 2
Premium Member class that manages the objects in PremiumMember

@author Zeke Marshall
@version Fall 2022
*/
public class PremiumMember {
        // private variables that are not accessible from outside the class
    private boolean premiumMemb;
    private boolean feeDue;

    /** default constructor that makes a premium member from the parameters
     * 
     * @param premMemb boolean value for whether the member is premium or not
     * @param _feeDue boolean value for whether the premium fee is due or not
     */
    public PremiumMember(boolean premMemb, boolean _feeDue){
        this.premiumMemb = premMemb;
        this.feeDue = _feeDue;
    }

    /** public method that specifies how to print out information about the premium member
     * @return returns message about the premium member
     */
    public String toString(){
        return "Premium Member: " + premiumMemb + "\nFee Due: " + feeDue;
    }

    /** public method to return if the member is a premium member
     * 
     * @return returns boolean value of premiumMemb
     */
    public boolean isPremiumMemb(){
        return this.premiumMemb;
    }

    /** public method to return if the member's fee is due
     * 
     * @return returns boolean value of feeDue
     */
    public boolean isFeeDue(){
        return this.feeDue;
    }

    /**
     * public method to change the value of feeDue to false
     */
    public void feePaid(){
        this.feeDue = false;
    }
}
