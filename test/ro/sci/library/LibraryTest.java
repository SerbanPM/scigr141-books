package ro.sci.library;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ro.sci.books.Book;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <h1>LibraryTest</h1>
 *
 * Tests that the addBook() method implemented in the Library class is performing as expected.
 * Tests that the remove() method implemented in the Library class is performing as expected.
 *
 * @author Serban PM
 * @version 1.0
 * @since 20190122
 */

public class LibraryTest {

    Library testLibrary;

    @Before
    public void before( ){
        System.out.println("Initializing test...");
    }

    /**
     * Creates a library in order to check if the two tested functions perform as expected.
     */
    @Before
    public void init( ){
        testLibrary = new Library();
    }

    /**
     * Tests that the addBook method is working as it is intended to.
     * The test is veryfing if the length of the array increases by one after adding an object.
     */
    @Test
    public void testAddBook( ){
        Book carte = new Book();
        testLibrary.addBook(carte);
        int numberOfItemsInLibrary = testLibrary.getItemCount();
        assertEquals(1, numberOfItemsInLibrary);
    }

    /**
     * Tests that the remove method is working as it is intended to.
     * The test is veryfing if the length of the array decreases by one after removing an object.
     */
    @Test
    public void testRemoveBook( ){
        Book carte = new Book();
        testLibrary.remove(carte);
        int numberOfItemsInLibrary = testLibrary.getItemCount();
        assertEquals(0, numberOfItemsInLibrary);
    }

    @After
    public void after( ){
        System.out.println("Test concluded.");
    }

}