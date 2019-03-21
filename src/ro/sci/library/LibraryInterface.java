package ro.sci.library;
import org.apache.log4j.Logger;
import ro.sci.books.Book;

/**
 * <h1>LibraryInterface</h1>
 * Specifies what methods are mandatory for any class that is implementing
 * this interface. For any such class, the methods addBook, getItemCount,
 * search, remove should all be implemented.
 *
 * @author Serban PM
 * @version 1.0
 * @since 20190122
 */
interface LibraryInterface {

    org.apache.log4j.Logger logger = Logger.getLogger(LibraryInterface.class);

    /**
     * Adds an object of type Book to the array list.
     *
     * @param book An object of type Book.
     */
    void addBook(Book book);

    /**
     * Counts the objects in the list using the size() method.
     *
     * @return itemCount An int representing the number of objects in the list.
     */
    int getItemCount( );

    /**
     * Searches for a title in the array list using the name of the object.
     *
     * @param book A string containing the title of the object to search.
     */
    Book search(String book);

    /**
     * Removes an object from the list.
     *
     * @param book The instance to be removed.
     */
    void remove(Book book);

}
