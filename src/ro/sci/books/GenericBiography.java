package ro.sci.books;

/**
 * <h1>GenericBiography</h1>
 * Generic class, child of the Novel class.
 * Used to create more specific instances of the Novel class.
 *
 * @author Serban PM
 * @version 1.0
 * @see ArtAlbum
 * @since 20190122
 */

import org.apache.log4j.Logger;

/**
 * Generic class representing a category of novels that can be found in this library.
 */
public class GenericBiography<T> extends Novel {

    /**
     * Creates a logger object for this class.
     */
    final static Logger logger = Logger.getLogger(GenericBiography.class);

    /**
     * A placeholder representing the domain of this GenericBiography.
     */
    private T domain;

    /**
     * Default constructor.
     */
    public GenericBiography( ){
    }

    /**
     * Getter method which returns the domain of this GenericBiography.
     *
     * @return A placeholder standing for the domain of this GenericBiography.
     */
    private T getDomain( ){
        return domain;
    }

    /**
     * Setter method used to input the domain of this GenericBiography.
     *
     * @param domain a generic parameter containing the domain of this GenericBiography.
     */
    public void setDomain(T domain){
        this.domain = domain;
    }

    /**
     * Method overriden from the {@link Novel} class.
     *
     * @return a String containing a specific representation of GenericBiography class instances.
     */
    @Override
    public String toString( ){
        return "GenericBiography: " + "nume = '" + getNume() + '\'' + " / nrPagini = " + getNrPagini() + " / ISBN " + getIsbn() + " / gen literar = '" + getType() + '\'' + " / domneniu = '" + getDomain() + '\'';
    }

}
