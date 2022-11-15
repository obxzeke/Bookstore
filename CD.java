/**
ITSC 1213 Project 2
CD class that manages the objects in CD

@author Zeke Marshall
@version Fall 2022
*/
public class CD extends Product {
    /** default constructor that makes a CD from the parameters
     * 
     * @param _index the index of the CD
     * @param _title the title of the CD
     * @param _price the price of the CD
     * @param _quantity the amount of CDs there are in the store
     */
    public CD(int _index, String _title, double _price, int _quantity){
        super(_index, _title, _price, _quantity);
    }

}
