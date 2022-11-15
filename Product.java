/**
ITSC 1213 Project 2
Product abstract class to manage products and acts as a parent class for books, cds, and dvds
@version Fall 2022
*/
public abstract class Product implements Comparable<Product>{
    // private variables that are not accessible from outside the class
    private int index;
    private String title; 
    private double price;
    private int quantity;

    /** default constructor that makes a product from the parameters
     * 
     * @param _index the index of the product
     * @param _title the title of the product
     * @param _price the price of the product
     * @param _quantity the amount of products there are in the store
     */
    public Product(int _index, String _title, double _price, int _quantity){
        this.index = _index;
        this.title = _title;
        this.price = _price;
        this.quantity = _quantity;
    }

    /** public method that specifies how to print out information about the product
     * @return returns message about the product
     */
    public String toString(){
        return "\t" + index + ". " + title + " : $" + price + " (" + quantity + " left)";
    }

    /** public method to return the index of the product
     * 
     * @return returns integer value of index
     */
    public int getIndex(){
        return this.index;
    }

    /** public method to return the title of the product
     * 
     * @return returns string value of title
     */
    public String getTitle(){
        return this.title;
    }

    /** public method to return the quantity of the product
     * 
     * @return returns integer value of quantity
     */
    public int getQuantity(){
        return this.quantity;
    }

    /** public method to return the price of the product
     * 
     * @return returns double value of the price
     */
    public double getPrice(){
        return this.price;
    }

    /**
     * public method to decrease the quantity of product by 1
     */
    public void purchased(){
        this.quantity--;
    }

    /** public method to add to the inventory of a product
     * 
     * @param quantity amount of products the user wants to add
     */
    public void addInventory(int quantity){
        this.quantity += quantity;
    }

    /** public method to compare products by price 
     * 
     * @param p the product being compared to
     * @return returns a integer value based on the comparison
    */
    @Override
    public int compareTo(Product p){
        if (this.getPrice() > p.getPrice()){
            return 1;
        }
        else if (this.getPrice() < p.getPrice()){
            return -1;
        }
        else{
            return 0;
        }
    }


}
