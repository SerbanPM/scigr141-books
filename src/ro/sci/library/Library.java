package ro.sci.library;

import org.apache.log4j.Logger;
import ro.sci.books.Book;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>Library</h1>
 * <p>
 * Implements {@link #addBook} method which is adding an object of type Book to the array list.
 * Implements {@link #getItemCount} method which Counts the objects in the list using the size() method.
 * Implements {@link #search} method which is searching for a title in the array list using the name of the object.
 * Implements {@link #remove} method which is removing an object from the list.
 * Creates a text file containing all the instances added and not removed from library.
 * Permits searching by name or by position number in the book list.
 *
 * @author Serban PM
 * @version 1.0
 * @since 20190122
 */


// Contains the "business" part of this library.
public class Library implements LibraryInterface {


    // Creates a logger object for this class.
    private final static org.apache.log4j.Logger logger = Logger.getLogger(Library.class);


    // Represents a list of books that can be found in this library.
    private List<Book> listOfBooks;

    public Library(Book books){

    }

    /**
     * Getter method which returns the list of books currently present in the library.
     *
     * @return A list representing the instances added and not removed from library.
     */
    public List<Book> getListOfBooks( ){
        return this.listOfBooks;
    }

    /**
     * Setter method used to input the content of the list of instances present in the library.
     *
     * @param listOfBooks A list containing the instances in the library.
     */
    public void setListOfBooks(List<Book> listOfBooks){
        this.listOfBooks = listOfBooks;
    }

    /**
     * Creates an array list with the instances contained in the library.
     */
    public Library( ){
        listOfBooks = new ArrayList<>();
    }

    /**
     * Adds an object of type Book to the array list.
     *
     * @param book An object of type Book.
     */
    public void addBook(Book book){
        logger.info("...adding book...");
        listOfBooks.add(book);
        logger.info("...book added");
    }

    /**
     * Counts the objects in the list using the size() method.
     *
     * @return numberOfItemsInLibrary An int representing the number of objects in the list.
     */
    public int getItemCount( ){
        // Represents the number of books that can be found in this library.
        return listOfBooks.size();
    }

    /**
     * Searches for a title in the array list using the name of the object.
     * <p>It compares the name of the searched object with the names of the objects
     * from the list using the equals method. Prints a different message for both
     * cases, match or no match.</p>
     *
     * @param book A string containing the title of the object to search.
     * @return carte An object matching the searched title.
     */
    public Book search(String book){
        for (Book carte : listOfBooks) {
            if (book.equals(carte.getNume())) {
                logger.info("Cartea cu titlul " + '\'' + book + '\'' + " exista in aceasta biblioteca. \n");
                return carte;
            }
        }
        logger.info("Cartea cu titlul " + '\'' + book + '\'' + " nu exista in aceasta bilioteca. \n");
        return null;

    }

    /**
     * Removes an object from the list.
     * The book is removed if the object is the same with the one from the method call.
     *
     * @param book The instance to be removed.
     */
    public void remove(Book book){
        logger.info("removing book");
        listOfBooks.remove(book);
        logger.info("book removed \n");
    }

    /**
     * Retrieves the object corresponding to the index parameter.
     * *
     *
     * @param index an integer reprezenting the idex of the item in the collection.
     * @return returns the item corresponding to the index parameter.
     */
    public Book getBook(int index){
        return listOfBooks.get(index);
    }

}











