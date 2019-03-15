package ro.sci.books;

/**
 * <h1>SculptureAlbum</h1>
 * Child class of the ArtAlbum class.
 * Used to create more specific instances of the ArtAlbum class.
 *
 * @author Serban PM
 * @version 1.0
 * @see ArtAlbum
 * @since 20190122
 */

/**
 * Represents a category of art albums that can be found in this library.
 */
public class SculptureAlbum extends ArtAlbum {

    /**
     * Represents the genre of the ArtAlbum.
     */
    private String gen;

    /**
     * Default constructor.
     */
    public SculptureAlbum( ){
    }

    /**
     * Creates an instance of SculptureAlbum with the specified type.
     *
     * @param gen A string containing the genre of this SculptureAlbum.
     */
    public SculptureAlbum(String gen){
        this.gen = gen;
    }

    /**
     * Getter method which returns the genre of this SculptureAlbum.
     *
     * @return A string representing the genre of this SculptureAlbum.
     */
    public String getGen( ){
        return gen;
    }

    /**
     * Setter method used to input the genre of this SculptureAlbum.
     *
     * @param gen A string containing the genre of this SculptureAlbum.
     */
    public void setGen(String gen){
        this.gen = gen;
    }

    /**
     * Method overriden from the {@link ArtAlbum} class.
     *
     * @return a String containing a specific representation of SculptureAlbum class instances.
     */
    @Override
    public String toString( ){
        return "SculptureAlbum: " + "nume = '" + getNume() + '\'' + " / nrPagini = " + getNrPagini() + " / ISBN " + getIsbn() + " / calitateHartie = '" + getCalitateHartie() + '\'' + " / gen = '" + gen + '\'';
    }
}

