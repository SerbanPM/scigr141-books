package ro.sci.books;

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
     * The year this book was published.
     */
    private int anAparitie;

    public Book(String nameInArray, int pagesInArray, int yearInArray){
        this.nume = nameInArray;
        this.nrPagini = pagesInArray;
        this.anAparitie = yearInArray;
    }

    public Book( ){
        nrPagini = 0;
        nume = "Fara nume";
        anAparitie = 0;
    }

//    public Book(String nume, int nrPagini, int anAparitie){
//        this.nume = nume;
//        this.nrPagini = nrPagini;
//        this.anAparitie = anAparitie;
//    }

    public void setNamePageYear(String nume, int nrPagini, int anAparitie){
        this.nume = nume;
        this.nrPagini = nrPagini;
        this.anAparitie = anAparitie;
    }

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
     * Getter method which returns the year this book book was published.
     *
     * @return An int containing the year this book was published.
     */
    public int getAnAparitie( ){
        return anAparitie;
    }

    /**
     * Setter method used to input the year this book book was published.
     *
     * @param anAparitie int data type containing the containing the year this book was published.
     */
    public void setAnAparitie(int anAparitie){
        this.anAparitie = anAparitie;
    }

    /**
     * Method overriden from the {@link Object} class.
     *
     * @return a String containing a specific representation of Book class instances.
     */
    @Override
    public String toString( ){
        return "Book: " + "nume = '" + nume + '\'' + " / nrPagini = " + nrPagini + " / editia " + anAparitie;
    }

}
