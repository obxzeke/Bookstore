package Project2;
/**
ITSC 1213 Project 2
DVD class that manages the objects in DVD

@author Zeke Marshall
@version Fall 2022
*/
public class DVD extends Product{
    /** default constructor that makes a DVD from the parameters
     * 
     * @param _index the index of the DVD
     * @param _title the title of the DVD
     * @param _price the price of the DVD
     * @param _quantity the amount of DVDs there are in the store
     */
    public DVD(int _index, String _title, double _price, int _quantity){
        super(_index, _title, _price, _quantity);
    }

}
