package ro.sci.library;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ro.sci.books.Book;

/**
 * <h1>LibraryTest</h1>
 * <p>
 * Tests that the addBook() method implemented in the Library class is performing as expected.
 * Tests that the remove() method implemented in the Library class is performing as expected.
 *
 * @author Serban PM
 * @version 1.0
 * @since 20190122
 */

public class LibraryTest {

    final static org.apache.log4j.Logger logger = Logger.getLogger(Library.class);

    private Library testLibrary;

    @Before
    public void before( ){
        logger.info("Initializing test... \n");
    }

    // Creates a library in order to check if the two tested functions perform as expected.
    @Before
    public void init( ){
        BasicConfigurator.configure();
        testLibrary = new Library();
    }

    // Tests that the addBook method is working as it is intended to.
    // The test is veryfing if the length of the array increases by one after adding an object.
    @Test
    public void testAddBook( ){
        Book carte = new Book();
        testLibrary.addBook(carte);
        int numberOfItemsInLibrary = testLibrary.getItemCount();
        Assert.assertEquals(1, numberOfItemsInLibrary);
    }

    // Tests that the remove method is working as it is intended to.
    // The test is veryfing if the length of the array decreases by one after removing an object.
    @Test
    public void testRemoveBook( ){
        Book carte = new Book();
        testLibrary.addBook(carte);

        Assert.assertEquals(carte, testLibrary.getBook(0));

        testLibrary.remove(carte);
        int numberOfItemsInLibrary = testLibrary.getItemCount();
        Assert.assertEquals(0, numberOfItemsInLibrary);
    }

    // Testing that the search method is matching the contained item with the item that it is supposed to be inside.
    @Test
    public void search( ){
        Book carte = new Book("numeTest", 300, "3456-567-45-2");
        testLibrary.addBook(carte);
        String testName = testLibrary.getBook(0).getNume();
        Assert.assertEquals(carte, testLibrary.search(testName));
    }

    @After
    public void after( ){
        logger.info("...Test concluded.");
    }


}