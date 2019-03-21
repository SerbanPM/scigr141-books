package ro.sci.main;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import ro.sci.books.*;
import ro.sci.library.CustomException;
import ro.sci.library.Library;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


/**
 * <h1>BookManager</h1>
 * Calls the {@link #addBook(Book carte)} method which is used to add objects to the list.
 * Calls the {@link #getItemCount()} method which is used to count the objects in the list.
 * Calls the {@link #search(String ceCauti)} method which is used to searche for a title in the list.
 * Calls the {@link #remove(Book book)} method which is used to remove objects from the list.
 * Prints the list of objects present in the list.
 * Implements writing a text file containing the list of objects from the list.
 * Implements reading the file and printing the list of objects from the list.
 * Implements reading from keyboard using eighter the name of the object or the
 * position number on the list.
 * <p>
 * It also implements collections using Arrays, the purpose being to show the differences between
 * the various ways to implement collections.
 *
 * @author Serban PM
 * @version 1.0
 * @since 20190122
 */

/**
 * Manages the list of {@link Book} objects.
 */
class BookManager {

    /*
     * Creates a logger object for this class.
     * There are different levels of logging.
     * Depending on the level specified in the log4j.properties file, it skips the above levels.
     * Each of the various levels of logging are used for particular situations.
     * <p>
     * This is the debug level of logging - use at the start and at the end of the function:
     * logger.debug("This is tew gaseste  DEBUG").
     * <p>
     * The info level of logging - for logging parameters just before calling an external function:
     * logger.info("This is INFO").
     * <p>
     * The warn level of logging - for logging suspicious input or state, where the program  will default to system settings:
     * logger.warn("This is WARN").
     * <p>
     * The error level of logging - for logging errors, for example trying to open file that is not there:
     * logger.error("Something went wrong!");
     */
    private final static Logger logger = Logger.getLogger(BookManager.class);

    public static void main(String[] args){

        /**
         * Initializes the properties file.
         *
         * @see "log4j.properties" file.
         */
        BasicConfigurator.configure();

        // Creates objects with the given arguments.
        Book carte1 = new Book();
        carte1.setNume("Prima carte");
        carte1.setNrPagini(10);
        carte1.setIsbn("973-8180-59-7");

        Book carte2 = new Book();
        carte2.setNume("A doua carte");
        carte2.setNrPagini(100);
        carte2.setIsbn("973-8190-49-1");

        Book carte3 = new Book();
        carte3.setNume("A treia carte");
        carte3.setNrPagini(50);
        carte3.setIsbn("973-8180-59-7");

        Novel nuv1 = new Novel();
        nuv1.setNume("Primul roman");
        nuv1.setNrPagini(100);
        nuv1.setIsbn("973-8280-75-5");
        nuv1.setType("Fantasy");

        Novel nuv2 = new Novel();
        nuv2.setNume("Al doilea roman");
        nuv2.setNrPagini(500);
        nuv2.setIsbn("973-8187-48-3");
        nuv2.setType("Policier");

        ArtAlbum art1 = new ArtAlbum();
        art1.setNume("Primul catalog de arta");
        art1.setNrPagini(20);
        art1.setIsbn("973-8182-49-3");
        art1.setCalitateHartie("Basic");

        ArtAlbum art2 = new ArtAlbum();
        art2.setNume("Al doilea catalog de arta");
        art2.setNrPagini(40);
        art2.setIsbn("973-8180-46-1");
        art2.setCalitateHartie("Extra");

        ArtAlbum art3 = new ArtAlbum();
        art3.setNume("Al treilea catalog de arta");
        art3.setNrPagini(40);
        art3.setIsbn("973-8182-49-3");
        art3.setCalitateHartie("Normal");

        SculptureAlbum sculpture1 = new SculptureAlbum();
        sculpture1.setNume("Primul catalog de sculptura");
        sculpture1.setNrPagini(200);
        sculpture1.setIsbn("973-8184-43-7");
        sculpture1.setCalitateHartie("Normal");
        sculpture1.setGen("Bronz timpuriu");

        SculptureAlbum sculpture2 = new SculptureAlbum();
        sculpture2.setNume("Al doilea catalog de sculptura");
        sculpture2.setNrPagini(200);
        sculpture2.setIsbn("973-8180-41-1");
        sculpture2.setCalitateHartie("Extra");
        sculpture2.setGen("Marmura");

        GenericBiography<Object> biography1 = new GenericBiography<>();
        biography1.setNume("Generic Stuff no 1");
        biography1.setNrPagini(300);
        biography1.setIsbn("973-8181-48-6");
        biography1.setType("Autobiography");
        biography1.setDomain("Compozitori");

        GenericBiography<Object> biography2 = new GenericBiography<>();
        biography2.setNume("Generic Stuff no 2");
        biography2.setNrPagini(2500);
        biography2.setIsbn("971-8183-48-1");
        biography2.setType("Biography");
        biography2.setDomain("Pictori");

        Book nuvela = new Novel();
        nuvela.setNume("Al treilea roman");
        nuvela.setNrPagini(100);
        nuvela.setIsbn("973-8180-49-2");
        ((Novel) nuvela).setType("Action");

        Book albumArta = new ArtAlbum();
        albumArta.setNume("Al treilea catalog de arta");
        albumArta.setNrPagini(40);
        albumArta.setIsbn("973-8180-48-4");
        ((ArtAlbum) albumArta).setCalitateHartie("Basic");

        Book albumSculptura = new SculptureAlbum();
        albumSculptura.setNume("Al treilea catalog de sculptura");
        albumSculptura.setNrPagini(50);
        albumSculptura.setIsbn("973-8179-45-5");
        ((SculptureAlbum) albumSculptura).setCalitateHartie("Normal");
        ((SculptureAlbum) albumSculptura).setGen("Lemn");

        Book biography = new GenericBiography<>();
        biography.setNume("Generic Stuff no 3");
        biography.setNrPagini(477);
        biography.setIsbn("972-8379-41-2");
        ((GenericBiography) biography).setType("Autobiography");
        ((GenericBiography) biography).setDomain("Scriitori");


        // =============================Implementing collections using ArrayLists ===================================

        System.out.println("\n ================ ArrayList Collection ================ \n");

        // Creates an array list with the added objects.
        Library librarie = new Library();

        // Adds items to the list.
        librarie.addBook(carte1);
        librarie.addBook(carte2);
        librarie.addBook(nuv1);
        librarie.addBook(nuv2);
        librarie.addBook(art1);
        librarie.addBook(art2);
        librarie.addBook(sculpture1);
        librarie.addBook(sculpture2);
        librarie.addBook(biography1);
        librarie.addBook(biography2);
        librarie.addBook(nuvela);
        librarie.addBook(albumArta);
        librarie.addBook(albumSculptura);
        librarie.addBook(biography);

        // Removes intems from the list
        librarie.remove(art2);

        // Writes and prints the item list.
        List cartileDinBiblioteca = librarie.getListOfBooks();

        // Counts and prints the number of the items in the list.
        System.out.println("Numarul de carti existente in biblioteca este: " + librarie.getItemCount() + "\n");

        // Writes a file containing the list of objects in the library.
        File arrayListInventory = new File("src/ro/sci/resources/arrayListLibrary.txt");
        try (BufferedWriter fileWriter01 = new BufferedWriter(new FileWriter("src/ro/sci/resources/arrayListLibrary.txt"))) {

            // Creates a string containing the books in the library.
            String listaNeprelucrata = cartileDinBiblioteca.toString();

            // Eliminates the first and the last characters from the string.
            String centralizatorCarti01 = listaNeprelucrata.substring(1, listaNeprelucrata.length() - 1);

            // Splits the string where a certain pattern is found.
            String[] elementeLibrarie01 = centralizatorCarti01.split(",\\s");
            fileWriter01.write("In biblioteca se afla urmatoarele titluri:");

            // Java foreach loop prints the separated elements of the library.
            // Add position numbers to every element of the library.
            int index = 1;
            for (String e : elementeLibrarie01) {
                fileWriter01.write("\n~" + (index++) + "~ " + e);
            }

        } catch (IOException e) {
            logger.error("General I/O exception for file: " + arrayListInventory.toString());
        }

        // Reads the file containing the list of objects in the library.
        Scanner readArrayListInventory = null;
        try {
            logger.info("...reading file...");
            readArrayListInventory = new Scanner(new File("src/ro/sci/resources/arrayListLibrary.txt"));
            while (readArrayListInventory.hasNextLine()) {
                System.out.println(readArrayListInventory.nextLine());
            }
            logger.info("...file reading done. \n");
        } catch (FileNotFoundException e) {
            logger.error("...file not found " + e.getMessage());
        }
        readArrayListInventory.close();

        // Searches for a book using the name inquired by user.
        // Prints the result of the search.
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Introduceti numele cartii cautate: ");
        String mySearch = keyboard.next().concat(keyboard.nextLine());
        librarie.search(mySearch);

        // Searches for a book using the position number inquired by user.
        // Prints the name of the book.
        System.out.println("Introduceti numarul pozitiei cautate din lista de " + librarie.getItemCount() + " carti existente in biblioteca:");
        int myint = keyboard.nextInt();
        String myString = keyboard.nextLine();
        System.out.println("Cartea aflata la pozitia ~" + myint + "~ este:");

        try {
            List<String> allLines = Files.readAllLines(Paths.get("src/ro/sci/resources/arrayListLibrary.txt"));
            String[] arrayLines = allLines.toArray(new String[0]);
            System.out.println(arrayLines[myint + 1] + "\n\n");
        } catch (IOException e) {
            logger.error("Yay, something went wrong!", e);
        }


        // =============================Implementing collections using Arrays ===================================

        System.out.println(" ================ Array Collection ================ \n");

        // Reads the input from the user and sets it as the array lenght.
        int arraySize;
        System.out.println("Cate carti doriti sa introduceti in biblioteca?");
        arraySize = keyboard.nextInt();
        Book[] booksInArray = new Book[arraySize];

        /**
         * Java foreach loop that takes input from user and uses the data as parameters to create
         * customized instances of class Book.
         * Prints all the elements of the array.
         *
         * @param nameInArray sets input string as the name of the book being entered in the library.
         * @param pagesInArray sets input int as the number of pages of the book being entered in the library.
         * @param isbnInArray sets input string as the ISBN code of the book being entered in the library.
         */
        for (int i = 0; i < arraySize; i++) {
            System.out.println("\nPentru articolul cu numarul ~" + (i + 1) + "~:");
            System.out.println("Introduceti numele cartii pe care doriti sa o introduceti in biblioteca:");
            String nameInArray = keyboard.next().concat(keyboard.nextLine());
            System.out.println("Introduceti numarul de pagini al cartii pe care doriti sa o introduceti in biblioteca:");
            int pagesInArray = keyboard.nextInt();

            if (pagesInArray < 100) {
                try {
                    throw new CustomException("*** The size of this item is too small to be kept in this library ***");
                } catch (CustomException e) {
                    logger.error(e.getMessage());
                }
            } else {
                pagesInArray = pagesInArray;
            }

            System.out.println("Introduceti codul ISBN al cartii pe care doriti sa o introduceti in biblioteca (in format ***-****-**-*):");
            String isbnInArray = keyboard.next().concat(keyboard.nextLine());
            Book arr1 = new Book(nameInArray, pagesInArray, isbnInArray);
            booksInArray[i] = arr1;

        }

        // Prints all the array elements.
        System.out.println("\nAti adaugat in biblioteca urmatoarele " + arraySize + " carti:");
        for (int counter = 0; counter < arraySize; counter++) {
            logger.info((counter + 1) + ") " + booksInArray[counter]);
        }

        // Takes input from user and calculates de index of the item to be removed.
        System.out.println("\nIntroduceti numarul cartii pe care doriti sa o scoateti din librarie: ");
        int positionToRemove = keyboard.nextInt();
        int indexToRemove = positionToRemove - 1;

        // Removes an item from the array, copying the remaining items in a different array with a length diminished by one.
        Book[] diminishedArray = new Book[booksInArray.length - 1];
        for (int i = 0; i < booksInArray.length; i++) {
            if (i < indexToRemove) {
                diminishedArray[i] = booksInArray[i];
            } else if (i > indexToRemove) {
                diminishedArray[i - 1] = booksInArray[i];
            }
        }

        // Prints the new array.
        System.out.println("Au mai ramas in biblioteca urmatoarele titluri:");
        for (int counter = 0; counter < diminishedArray.length; counter++) {
            logger.info((counter + 1) + ") " + diminishedArray[counter]);
        }

        // Writes a file containing the list of objects in the array.
        File arrayInventory = new File("src/ro/sci/resources/arrayLibrary.txt");
        try (BufferedWriter fileWriter02 = new BufferedWriter(new FileWriter("src/ro/sci/resources/arrayLibrary.txt"))) {

            String arrayToFile = Arrays.toString(diminishedArray);
            String centralizatorCarti02 = arrayToFile.substring(1, arrayToFile.length() - 1);
            String[] elementeLibrarie02 = centralizatorCarti02.split(",\\s");
            fileWriter02.write("Dupa indepartarea din bibilioteca a cartii indicate de user, au mai ramas urmatoarele titluri:\n");
            int index = 1;
            for (String e : elementeLibrarie02) {
                fileWriter02.write("\n~" + index++ + "~ " + e);
            }

        } catch (IOException e) {
            logger.error("General I/O exception for file: " + arrayInventory.toString());
        }
        keyboard.close();


        // =============================Implementing collections using LinkedHashSet ===================================

        System.out.println("\n ================ LinkedHashSet ================ \n");

        Set<Book> setLibrary = new LinkedHashSet<>();
        System.out.println("The following objects have been added to setLibrary after eliminating the doubled ISBNs:");

        /**
         * Adding two objects with the same isbn, carte1 and carte3. The equals() and hashCode() method implemeted in the Book class
         * ensures that we only find one such object in this LinkedHashSet.
         *
         * {@link #equals(Object()} in Book class.
         * {@link #hashCode()} in Book class.
         */
        setLibrary.add(carte1);
        setLibrary.add(carte2);
        setLibrary.add(carte3);


        /**
         * Adding two objects with the same isbn, art1 and art3. The equals() and hashCode() method implemeted in the Book class
         * ensures that we only find one such object in this LinkedHashSet.
         *
         * {@link #equals(Object()} in Book class.
         * {@link #hashCode()} in Book class.
         */
        setLibrary.add(art1);
        setLibrary.add(art2);
        setLibrary.add(art3);

        // Iterate through the collection
        for (Object element : setLibrary) {
            System.out.println(element);
        }

        System.out.println("\nOperations in LinkedHashSet - others that we already saw in ArrayList and Array collections:");
        // Counting the elements of the LinkedHashSet.
        logger.info("Size of LinkedHashSet is: " + setLibrary.size() + " items.");
        // Displaying the LinkedHashSet.
        logger.info("The original LinkedHashSet is " + setLibrary);
        // Removing an element from the LinkedHashSet.
        logger.info("Removing 'carte1' from list  = " + setLibrary.remove(carte1));
        // Trying to remove an obeject that is not in the LinkedHashSet.
        logger.info("Trying to remove 'carte3' which is not present: " + setLibrary.remove(carte3));
        // This method returns true if this set contains the specified element.
        logger.info("Checking if 'art1' is present = " + setLibrary.contains(art1));
        // Displaying the LinkedHashSet.
        logger.info("Updated LinkedHashSet: " + setLibrary);

        // Creating an array from a LinkedHashSet.
        Object[] arrayFromLinkedHashSet = setLibrary.toArray();
        System.out.println("\nThe array created from the LinkedHashSet is:");
        for (Object o : arrayFromLinkedHashSet) logger.info(o);

        System.out.println("\nThe clear() method removes all the items in the collection.");
        setLibrary.clear();
        logger.info("LinkedHashSet after use of clear() method: " + setLibrary);
    }
}







