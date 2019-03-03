package ro.sci.library;

import ro.sci.books.Book;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * <h1>Library</h1>
 * Implements adding, removing, classifying, centralizing books in the library.
 * Creates a text file containing all the instances added and not removed from library.
 * Permits searching by name or by position number in the book list.
 *
 * @author Serban PM
 * @version 1.0
 * @since 20190122
 */

/**
 * Contains the "business" part of this library.
 */
public class Library {

    /**
     * Represents a list of books that can be found in this library.
     */
    private List<Book> listOfBooks;

    /**
     * Represents the number of books that can be found in this library.
     */
    private int numberOfItemsInLibrary;

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
     * @param carte An object of type Book.
     */
    public void addBook(Book carte){
        listOfBooks.add(carte);
    }

    /**
     * Counts the objects in the list using the size() method.
     *
     * @return itemCount An int representing the number of objects in the list.
     */
    public int getItemCount( ){
        int itemCount = listOfBooks.size();
        return itemCount;
    }

    /**
     * Searches for a title in the array list using the name of the object.
     * <p>It compares the name of the searched object with the names of the objects
     * from the list using the equals method. Prints a different message for both
     * cases, match or no match.</p>
     *
     * @param ceCauti A string containing the title of the object to search.
     * @return carte An object matching the searched title.
     */
    public Book search(String ceCauti){
        for (Book carte : listOfBooks) {
            if (ceCauti.equals(carte.getNume())) {
                System.out.println("Cartea cu titlul " + '\'' + ceCauti + '\'' + " exista in aceasta biblioteca!");
                return carte;
            }
        }
        System.out.println("Cartea cu titlul " + '\'' + ceCauti + '\'' + " nu exista in aceasta bilioteca!");
        return null;
    }

    /**
     * Removes an object from the list.
     * The book is removed if the object is the same with the one from the method call.
     *
     * @param book A string containing the name of the instance.
     */
    public void remove(Book book){
        listOfBooks.remove(book);
    }


}











