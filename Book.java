package Project2;
/**
ITSC 1213 Project 2
Book class that manages the objects in Book

@author Zeke Marshall
@version Fall 2022
*/
public class Book extends Product{
    
    /** default constructor that makes a book from the parameters
     * 
     * @param _index the index of the book
     * @param _title the title of the book
     * @param _price the price of the book
     * @param _quantity the amount of books there are in the store
     */
    public Book(int _index, String _title, double _price, int _quantity){
        super(_index, _title, _price, _quantity);
    }

}