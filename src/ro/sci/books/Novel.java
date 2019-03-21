package ro.sci.books;

/**
 * <h1>Novel</h1>
 * Child class of the Book class.
 * Used to create more specific instances of the Book class.
 *
 * @author Serban PM
 * @version 1.0
 * @see Book
 * @since 20190122
 */

import org.apache.log4j.Logger;

/**
 * Represents a category of books that can be found in this library.
 */
public class Novel extends Book {

    /**
     * Creates a logger object for this class.
     */
    final static Logger logger = Logger.getLogger(Novel.class);

    /**
     * The type of the novel.
     */
    private String type;

    /**
     * Default constructor.
     */
    public Novel( ){
    }

    /**
     * Creates an instance of Novel with the specified type.
     *
     * @param type A string containing the type of this novel.
     */
    private Novel(String type){
        this.type = type;
    }

    /**
     * Getter method which returns the type of this novel.
     *
     * @return A string representing the type of this novel.
     */
    String getType( ){
        return type;
    }

    /**
     * Setter method used to input the type of this novel.
     *
     * @param type A string containing the type of this novel.
     */
    public void setType(String type){
        this.type = type;
    }

    /**
     * Method overriden from the {@link Book} class.
     *
     * @return a String containing a specific representation of ArtAlbum class instances.
     */
    @Override
    public String toString( ){
        return "Novel: " + "nume = '" + getNume() + '\'' + " / nrPagini = " + getNrPagini() + " / ISBN " + getIsbn() + " / gen literar = '" + type + '\'';
    }
}
