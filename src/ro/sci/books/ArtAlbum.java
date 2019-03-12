package ro.sci.books;

/**
 * <h1>ArtAlbum</h1>
 * Child class of the Book class.
 * Used to create more specific instances of the Book class.
 *
 * @author Serban PM
 * @version 1.0
 * @see Book
 * @since 20190122
 */

/**
 * Represents a category of books that can be found in this library.
 */
public class ArtAlbum extends Book {

    /**
     * Represents the paper quality of the albums.
     */
    private String calitateHartie;

    /**
     * Getter method which returns the paper quality of this art album.
     *
     * @return A string representing this art album paper quality.
     */
    public String getCalitateHartie( ){
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
        return "ArtAlbum: " + "nume = '" + getNume() + '\'' + " / nrPagini = " + getNrPagini() + " / editia " + getAnAparitie() + " / calitateHartie = '" + calitateHartie + "\'";
    }

}
