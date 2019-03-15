package ro.sci.management;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import ro.sci.books.ArtAlbum;
import ro.sci.books.Book;
import ro.sci.books.Novel;
import ro.sci.books.SculptureAlbum;
import ro.sci.library.Library;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


/**
 * <h1>InventoryManagement</h1>
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
public class InventoryManagement {

    /**
     * Create the logger object.
     */
    final static Logger logger = Logger.getLogger(InventoryManagement.class);

    public static void main(String[] args){

        /**
         * Initialize the properties file
         *
         * @see "log4j.properties" file
         */
        PropertyConfigurator.configure("log/log4j.properties");

        /**
         * There are different levels of logging.
         * Depending on the level specified in the log4j.properties file, it skips the above levels
         */
        logger.debug("This is DEBUG");

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

        /**
         * Creates an array list with the added objects.
         */
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
        librarie.addBook(nuvela);
        librarie.addBook(albumArta);
        librarie.addBook(albumSculptura);

        // Removes intems from the list
        librarie.remove(art2);

        // Writes and prints the item list.
        List cartileDinBiblioteca = librarie.getListOfBooks();

        // This line is used to verify the output, there is no need to print it by default
        // System.out.println("\n" + cartileDinBiblioteca);

        System.out.println("\n============ ArrayList ============");

        // Counts and prints the number of the items in the list.
        System.out.println("\nNumar de books existente in biblioteca: " + librarie.getItemCount());

        /**
         * Writes a file containing the list of objects in the library.
         */
        File arrayListInventory = new File("src/ro/sci/resources/arrayListLibrary.txt");
        try (BufferedWriter fileWriter01 = new BufferedWriter(new FileWriter("src/ro/sci/resources/arrayListLibrary.txt"))) {

            /**
             * Creates a string containing the books in the library.
             */
            String listaNeprelucrata = cartileDinBiblioteca.toString();

            /**
             * Eliminates the first and the last characters from the string.
             */
            String centralizatorCarti01 = listaNeprelucrata.substring(1, listaNeprelucrata.length() - 1);
            /**
             * Splits the string where a certain pattern is found.
             */
            String[] elementeLibrarie01 = centralizatorCarti01.split(",\\s");
            fileWriter01.write("\nIn biblioteca se afla urmatoarele titluri:\n");

            /**
             * 1. Java foreach loop prints the separated elements of the library.
             * 2. Add position numbers to every element of the library.
             */
            int index = 1;
            for (String e : elementeLibrarie01) {
                fileWriter01.write("\n~" + String.valueOf(index++) + "~ " + e);
            }

        } catch (IOException e) {
            System.out.println("General I/O exception for file: " + arrayListInventory.toString());
        }

        /**
         * Reads the file containing the list of objects in the library.
         */
        Scanner readArrayListInventory = null;
        try {
            readArrayListInventory = new Scanner(new File("src/ro/sci/resources/arrayListLibrary.txt"));
            while (readArrayListInventory.hasNextLine()) {
                System.out.println(readArrayListInventory.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Exception occured: " + e);
        }


        /**
         * Searches for a book using the name inquired by user.
         * Prints the result of the search.
         */
        Scanner keyboard = new Scanner(System.in);
        System.out.println("\nIntroduceti numele cartii cautate: ");
        String mySearch = keyboard.next().concat(keyboard.nextLine());
        librarie.search(mySearch);

        /**
         * Searches for a book using the position number inquired by user.
         * Prints the name of the book.
         */
        System.out.println("\nIntroduceti numarul pozitiei cautate: ");
        int myint = keyboard.nextInt();
        String myString = keyboard.nextLine();
        System.out.println("\nCartea aflata la pozitia ~" + myint + "~ este: ");

        try {
            List<String> allLines = Files.readAllLines(Paths.get("src/ro/sci/resources/arrayListLibrary.txt"));
            String[] arrayLines = allLines.toArray(new String[0]);
            System.out.println(arrayLines[myint + 2]);
        } catch (IOException e) {
            e.printStackTrace();
        }


        /**
         * =============================Implementing collections using Arrays ===================================
         */

        System.out.println("\n============ Arrays ============");

        /**
         *  Reads the input from the user and sets it as the array lenght.
         */
        int arraySize;
        System.out.println("\nCate carti doriti sa introduceti in biblioteca?");
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
            System.out.println("\nPentru articolul cu numarul " + (i + 1) + ":");
            System.out.println("Introduceti numele cartii pe care doriti sa o introduceti in biblioteca:");
            String nameInArray = keyboard.next().concat(keyboard.nextLine());
            System.out.println("Introduceti numarul de pagini al cartii pe care doriti sa o introduceti in biblioteca:");
            int pagesInArray = keyboard.nextInt();
            System.out.println("Introduceti codul ISBN al cartii pe care doriti sa o introduceti in biblioteca (in format ***-****-**-*):");
            String isbnInArray = keyboard.next().concat(keyboard.nextLine());
            Book arr1 = new Book(nameInArray, pagesInArray, isbnInArray);
            booksInArray[i] = arr1;
        }

        // Prints all the array elements.
        System.out.println("\nAti adaugat in biblioteca urmatoarele " + arraySize + " carti:");
        for (int counter = 0; counter < arraySize; counter++) {
            System.out.println((counter + 1) + ") " + booksInArray[counter]);
        }

        // The info level of logging - for logging parameters just before calling an external function.
        logger.info("This is INFO");
        // The warn level of logging - for logging suspicious input or state, where the program  will default to system settings.
        logger.warn("This is WARN");

        /**
         * Takes input from user and calculates de index of the item to be removed.
         */
        System.out.println("\nIntroduceti numarul cartii pe care doriti sa o scoateti din librarie: ");
        int positionToRemove = keyboard.nextInt();
        int indexToRemove = positionToRemove - 1;

        /**
         * Removes an item from the array, copying the remaining items in a different array with a length diminished by one.
         */
        Book[] reducedArray = new Book[booksInArray.length - 1];
        for (int i = 0; i < booksInArray.length; i++) {
            if (i < indexToRemove) {
                reducedArray[i] = booksInArray[i];
            } else if (i > indexToRemove) {
                reducedArray[i - 1] = booksInArray[i];
            }
        }

        /**
         * Prints the new array.
         */
        System.out.println("\nAu mai ramas in biblioteca urmatoarele titluri:");
        for (int counter = 0; counter < reducedArray.length; counter++) {
            System.out.println((counter + 1) + ") " + reducedArray[counter]);
        }

        // This is the error level of logging.
        logger.error("This is ERROR");
        /**
         * Writes a file containing the list of objects in the array.
         */
        File arrayInventory = new File("src/ro/sci/resources/arrayLibrary.txt");
        try (BufferedWriter fileWriter02 = new BufferedWriter(new FileWriter("src/ro/sci/resources/arrayLibrary.txt"))) {

            String arrayToFile = Arrays.toString(reducedArray);
            String centralizatorCarti02 = arrayToFile.substring(1, arrayToFile.length() - 1);
            String[] elementeLibrarie02 = centralizatorCarti02.split(",\\s");
            fileWriter02.write("\nDupa indepartarea din bibilioteca a cartii indicate de user, au mai ramas urmatoarele titluri:\n");
            int index = 1;
            for (String e : elementeLibrarie02) {
                fileWriter02.write("\n~" + String.valueOf(index++) + "~ " + e);
            }

        } catch (IOException e) {
            System.out.println("General I/O exception for file: " + arrayInventory.toString());
        }

        /**
         * =============================Implementing collections using LinkedHashSet ===================================
         */

        System.out.println("\n============ LinkedHashSet<> ============");


        Set<Book> setLibrary = new LinkedHashSet<>();
        setLibrary.add(carte1);
        setLibrary.add(carte2);

        /**
         * This object has the same isbn as carte1. The equals() and hashCode() method implemeted in the Book class
         * ensures that we only find one such object in this LinkedHashSet.
         *
         * {@link #equals(Object()} in Book class.
         * {@link #hashCode()} in Book class.
         */
        setLibrary.add(carte3);

        setLibrary.add(art1);
        setLibrary.add(art2);

        /**
         * This object has the same ISBN as art1. The equals() and hashCode() method implemeted in the Book class
         * ensures that we only find one such object in this LinkedHashSet.
         *
         * {@link #equals(Object()} in Book class.
         * {@link #hashCode()} in Book class.
         */
        setLibrary.add(art3);

        // Iterate through the collection
        for (Object element : setLibrary) {
            System.out.println(element);
        }

        // Verify the presence of an item
        // <<<<<<<<<<<<< Set a scanner >>>>>>>>>>>>>>>
        // <<<<<<<<<<<<< addAll >>>>>>>>>>>
        if (setLibrary.contains(carte2)) {
            System.out.println("\nThe library does contain this book.");
        }

        // This is the debug level of logging.
        logger.debug("This is DEBUG");


    }
}







