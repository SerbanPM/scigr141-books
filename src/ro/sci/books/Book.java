package ro.sci.books;

import ro.sci.library.Library;

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

/**
 * Represents any category of books that can be found in this library.
 */
public class Book {

    /**
     * The number of pages of this book.
     */
    private int nrPagini;

    /**
     * The name of this book.
     */
    private String nume;

    /**
     * Getter method which returns the number of pages of this book.
     *
     * @return int data type, this book number of pages.
     */
    public int getNrPagini( ){
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
     * Method overriden from the {@link Object} class.
     *
     * @return a String containing a specific representation of Book class instances.
     */
    @Override
    public String toString( ){
        return "Book: " + "nrPagini = " + nrPagini + " / nume = '" + nume + '\'';
    }
}
