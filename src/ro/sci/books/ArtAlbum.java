package ro.sci.books;

/**
 * <h1ArtAlbum</h1>
 * Child class of the Book class.
 * Used to create more specific instances of the Book class.
 *
 * @author Serban PM
 * @version 1.0
 * @see Book
 * @since 20190122
 */

import org.apache.log4j.Logger;


/*
 * Represents a category of books that can be found in this library.
 */
public class ArtAlbum extends Book {


    // Creates a logger object for this class.
    final static Logger logger = Logger.getLogger(ArtAlbum.class);


    // Represents the paper quality of the albums.
    private String calitateHartie;

    /**
     * Getter method which returns the paper quality of this art album.
     *
     * @return A string representing this art album paper quality.
     */
    String getCalitateHartie( ){
        return calitateHartie;
    }

    /**
     * Setter method used to input the paper quality of this art album.
     *
     * @param calitateHartie A string containing the paper quality of this art album.
     */
    public void setCalitateHartie(String calitateHartie){
        this.calitateHartie = calitateHartie;
    }

    /**
     * Method overriden from the {@link Book} class.
     *
     * @return a String containing a specific representation of ArtAlbum class instances.
     */
    @Override
    public String toString( ){
        return "ArtAlbum: " + "nume = '" + getNume() + '\'' + " / nrPagini = " + getNrPagini() + " / ISBN " + getIsbn() + " / calitateHartie = '" + calitateHartie + "\'";
    }

}
