package ro.sci.books;

import org.apache.log4j.Logger;
import ro.sci.library.Library;

import java.util.Objects;

/**
 * <h1>Book</h1>
 * Represents books that can be added, removed, sorted, oredered, clasified, etc in this library.
 * Serves as a parent class for the more specific {@link Novel} and {@link ArtAlbum} classes.
 * Creates elements within {@link Library} class.
 *
 * @author Serban PM
 * @version 1.0
 * @since 20190122
 */

// Represents any category of books that can be found in this library.
public class Book {


    // Creates a logger object for this class.
    final static Logger logger = Logger.getLogger(Book.class);


    // The number of pages of this book.
    private int nrPagini;


    //The name of this book.
    private String nume;


    // The ISBN code of this book.
    private String isbn;


    // Default constructor.
    public Book( ){
    }

    /**
     * Creates new instances of class Book taking three parameters.
     * It is particularily used to create instances of the Book class using the parameters taken as input from user.
     *
     * @param nameInArray  A String containing the name of this book.
     * @param pagesInArray An int containing the number of pages of this book.
     * @param isbnInArray  A string containing the ISBN code of this book.
     */
    public Book(String nameInArray, int pagesInArray, String isbnInArray){
        this.nume = nameInArray;
        this.nrPagini = pagesInArray;
        this.isbn = isbnInArray;
    }


    /**
     * Getter method which returns the number of pages of this book.
     *
     * @return int data type, this book number of pages.
     */
    int getNrPagini( ){
        return nrPagini;
    }

    /**
     * Setter method used to input the number of pages of this book.
     *
     * @param numaroarecare int data type containing the number of pages of this book.
     */
    public void setNrPagini(int numaroarecare){
        nrPagini = numaroarecare;
    }

    /**
     * Getter method which returns the name of this book.
     *
     * @return A string containing this book name.
     */
    public String getNume( ){
        return nume;
    }

    /**
     * Setter method used to input the number of pages of this book.
     *
     * @param numeCarte an int data type containing the number of pages.
     */
    public void setNume(String numeCarte){
        nume = numeCarte;
    }

    /**
     * Getter method which returns the year this book book was published.
     *
     * @return An int containing the year this book was published.
     */
    String getIsbn( ){
        return isbn;
    }

    /**
     * Setter method used to input the ISBN code of this book.
     *
     * @param isbn string data type containing the ISBN code of this book.
     */
    public void setIsbn(String isbn){
        this.isbn = isbn;
    }

    /**
     * Method overriden from the {@link Object} class.
     *
     * @return a String containing a specific representation of Book class instances.
     */
    @Override
    public String toString( ){
        return "Book: " + "nume = '" + nume + '\'' + " / nrPagini = " + nrPagini + " / ISBN " + isbn;
    }

    /**
     * Method overriden from the {@link Object} class.
     * Compares memory location and only return true if two reference variable
     * are pointing to same memory location i.e. essentially they are same object.
     * In this setting, two objects are considered equal if the String parameter isbn is
     * the same.
     *
     * @return true if the two objects are equal.
     */
    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return getIsbn().equals(book.getIsbn());
    }

    /**
     * Tests for object inequality for this class.
     * In this setting, two objects are considered unequal if the String parameter isbn is not the same.
     *
     * @return the same string for name.
     */
    @Override
    public int hashCode( ){
        return Objects.hash(getIsbn());
    }
}
