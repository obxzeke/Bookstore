package Project2;
/**
ITSC 1213 Project 2
public interface to restock a product and calculate the total inventory of the bookstore
@author Zeke Marshall
@version Fall 2022
*/
public interface BookStoreSpecification {
    
    /** public method to add inventory to a product
     * 
     * @param index the index of the product the user wants to add to
     * @param quantity the amount of product the user wants to add
     */
    public void restockProduct(int index, int quantity);

    /** public method to add up all the inventory of each product in the store
     * 
     *  @return returns the total amount of inventory in the store
     */
    public double inventoryValue();
}
