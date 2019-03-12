package ro.sci.management;

import ro.sci.books.ArtAlbum;
import ro.sci.books.Book;
import ro.sci.books.Novel;
import ro.sci.books.SculptureAlbum;
import ro.sci.library.Library;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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

    public static void main(String[] args){

        // Creates objects with the given arguments.
        Book carte1 = new Book();
        carte1.setNume("Carte1");
        carte1.setNrPagini(10);
        carte1.setAnAparitie(2000);

        Book carte2 = new Book();
        carte2.setNume("Carte2");
        carte2.setNrPagini(100);
        carte2.setAnAparitie(1999);

        Book carte3 = new Book();
        carte3.setNume("Carte3");
        carte3.setNrPagini(50);
        carte3.setAnAparitie(1998);

        Book carte4 = new Book();
        carte4.setNume("Carte1");
        carte4.setNrPagini(20);
        carte4.setAnAparitie(4000);

        Novel nuv1 = new Novel();
        nuv1.setNume("Nuv1");
        nuv1.setNrPagini(100);
        nuv1.setAnAparitie(1997);
        nuv1.setType("roman de aventuri");

        Novel nuv2 = new Novel();
        nuv2.setNume("Nuv2");
        nuv2.setNrPagini(500);
        nuv2.setAnAparitie(1996);
        nuv2.setType("roman politist");

        Novel nuv3 = new Novel();
        nuv3.setNume("Nuv3");
        nuv3.setNrPagini(1000);
        nuv3.setAnAparitie(1995);
        nuv3.setType("roman istoric");

        ArtAlbum art1 = new ArtAlbum();
        art1.setNume("Art1");
        art1.setNrPagini(20);
        art1.setAnAparitie(1994);
        art1.setCalitateHartie("cool");

        ArtAlbum art2 = new ArtAlbum();
        art2.setNume("Art2");
        art2.setNrPagini(40);
        art2.setAnAparitie(1993);
        art2.setCalitateHartie("awsome");

        ArtAlbum art3 = new ArtAlbum();
        art3.setNume("Art3");
        art3.setNrPagini(60);
        art3.setAnAparitie(1992);
        art3.setCalitateHartie("not that good");

        SculptureAlbum sculpture1 = new SculptureAlbum();
        sculpture1.setNume("Sculpture1");
        sculpture1.setNrPagini(200);
        sculpture1.setAnAparitie(1991);
        sculpture1.setCalitateHartie("awsome");
        sculpture1.setGen("bronz");

        SculptureAlbum sculpture2 = new SculptureAlbum();
        sculpture2.setNume("Sculpture2");
        sculpture2.setNrPagini(200);
        sculpture2.setAnAparitie(1990);
        sculpture2.setCalitateHartie("awsome");
        sculpture2.setGen("marmura");

        SculptureAlbum sculpture3 = new SculptureAlbum();
        sculpture3.setNume("Sculpture3");
        sculpture3.setNrPagini(500);
        sculpture3.setAnAparitie(1989);
        sculpture3.setCalitateHartie("not that good");
        sculpture3.setGen("bronz");

        Book nuvela = new Novel();
        nuvela.setNume("Nuv1");
        nuvela.setNrPagini(100);
        nuvela.setAnAparitie(1988);
        ((Novel) nuvela).setType("action");

        Book albumArta = new ArtAlbum();
        albumArta.setNume("Art2");
        albumArta.setNrPagini(40);
        albumArta.setAnAparitie(1987);
        ((ArtAlbum) albumArta).setCalitateHartie("impressive");

        Book albumSculptura = new SculptureAlbum();
        albumSculptura.setNume("Sculpture3");
        albumSculptura.setNrPagini(50);
        albumSculptura.setAnAparitie(1986);
        ((SculptureAlbum) albumSculptura).setCalitateHartie("ioioi");
        ((SculptureAlbum) albumSculptura).setGen("dunno");

//        // Creates an array list with the added objects.
//        Library librarie = new Library();
//
//        // Adds items to the list.
//        librarie.addBook(carte1);
//        librarie.addBook(carte2);
//        librarie.addBook(carte3);
//        librarie.addBook(nuv1);
//        librarie.addBook(nuv2);
//        librarie.addBook(nuv3);
//        librarie.addBook(art1);
//        librarie.addBook(art2);
//        librarie.addBook(art3);
//        librarie.addBook(sculpture1);
//        librarie.addBook(sculpture2);
//        librarie.addBook(sculpture3);
//        librarie.addBook(nuvela);
//        librarie.addBook(albumArta);
//        librarie.addBook(albumSculptura);
//
//        // Removes intems from the list
//        librarie.remove(art2);
//
//        // Writes and prints the item list.
//        List cartileDinBiblioteca = librarie.getListOfBooks();
//
//        // This line is used to verify the output, there is no need to print it by default
//        // System.out.println("\n" + cartileDinBiblioteca);
//
//        System.out.println("\n============ ArrayList ============");
//
//        // Counts and prints the number of the items in the list.
//        System.out.println("\nNumar de books existente in biblioteca: " + librarie.getItemCount());
//
//        /**
//         * Writes a file containing the list of objects in the library.
//         */
//        File arrayListInventory = new File("src/ro/sci/resources/ArrayList Library.txt");
//        try (BufferedWriter fileWriter01 = new BufferedWriter(new FileWriter("src/ro/sci/resources/ArrayList Library.txt"))) {
//
//            // Creates a string containing the books in the library.
//            String listaNeprelucrata = cartileDinBiblioteca.toString();
//            // Eliminates the first and the last characters from the string.
//            String centralizatorCarti01 = listaNeprelucrata.substring(1, listaNeprelucrata.length() - 1);
//            // Splits the string where a certain pattern is found.
//            String[] elementeLibrarie01 = centralizatorCarti01.split(",\\s");
//            fileWriter01.write("\nIn biblioteca se afla urmatoarele titluri:\n");
//            // Java foreach loop prints the separated elements of the library.
//            // Adds position numbers to every element of the library.
//            int index = 1;
//            for (String e : elementeLibrarie01) {
//                fileWriter01.write("\n~" + String.valueOf(index++) + "~ " + e);
//            }
//
//        } catch (IOException e) {
//            System.out.println("General I/O exception for file: " + arrayListInventory.toString());
//        }
//
//// This part of code prints the content of the file "Elemente Librarie"
//// If necesary, uncomment the code
//
//        /**
//         * Reads the file containing the list of objects in the library.
//         */
////        Scanner readArrayListInventory = null;
////        try {
////            readArrayListInventory = new Scanner(new File("src/ro/sci/resources/ArrayList Library.txt"));
////            while (readArrayListInventory.hasNextLine()) {
////                System.out.println(readArrayListInventory.nextLine());
////            }
////        } catch (FileNotFoundException e) {
////            System.out.println("Exception occured: " + e);
////        }
//
//        /**
//         * Searches for a book using the name inquired by user.
//         * Prints the result of the search.
//         */
//        Scanner keyboard = new Scanner(System.in);
//        System.out.println("\nIntroduceti numele cartii cautate: ");
//        String mySearch = keyboard.next().concat(keyboard.nextLine());
//        librarie.search(mySearch);
//
//        /**
//         * Searches for a book using the position number inquired by user.
//         * Prints the name of the book.
//         */
//        System.out.println("\nIntroduceti un numarul pozitiei cautate: ");
//        int myint = keyboard.nextInt();
//        String myString = keyboard.nextLine();
//        System.out.println("\nCartea aflata la pozitia ~" + myint + "~ este: ");
//
//        try {
//            List<String> allLines = Files.readAllLines(Paths.get("src/ro/sci/resources/ArrayList Library.txt"));
//            String[] arrayLines = allLines.toArray(new String[0]);
//            System.out.println(arrayLines[myint]);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        /**
//         * =============================Implementing collections using Arrays ===================================
//         */
//
//        System.out.println("\n============ Arrays ============");
//
//        // Reads the input from the user and sets it as the array lenght.
//        int arraySize;
//        System.out.println("\nCate carti doriti sa introduceti in biblioteca?");
//        arraySize = keyboard.nextInt();
//        Book[] booksInArray = new Book[arraySize];
//
//        // Java foreach loop that takes input from user and uses the data as parameters to create
//        // customized instances of class Book
//        for (int i = 0; i < arraySize; i++) {
//            System.out.println("\nPentru articolul cu numarul " + (i + 1) + ":");
//            System.out.println("Introduceti numele cartii pe care doriti sa o introduceti in biblioteca:");
//            String nameInArray = keyboard.next().concat(keyboard.nextLine());
//            System.out.println("Introduceti numarul de pagini al cartii pe care doriti sa o introduceti in biblioteca:");
//            int pagesInArray = keyboard.nextInt();
//            System.out.println("Introduceti anul in care a fost publicata cartea pe care doriti sa o introduceti in biblioteca:");
//            int yearInArray = keyboard.nextInt();
//            Book arr1 = new Book(nameInArray, pagesInArray, yearInArray);
//            booksInArray[i] = arr1;
//        }
//        // Print all the array elements.
//        System.out.println("\nAti adaugat in biblioteca urmatoarele " + arraySize + " carti:");
//        for (int counter = 0; counter < arraySize; counter++) {
//            System.out.println((counter + 1) + ") " + booksInArray[counter]);
//        }
//
//        // Takes input from user and calculates de index of the item to be removed.
//        System.out.println("\nIntroduceti numarul cartii pe care doriti sa o scoateti din librarie: ");
//        int positionToRemove = keyboard.nextInt();
//        int indexToRemove = positionToRemove - 1;
//
//         // Rmoves an item from the array, copying the remaining items in a different array with a length diminished by one.
//        Book[] reducedArray = new Book[booksInArray.length - 1];
//        for (int i = 0; i < booksInArray.length; i++) {
//            if (i < indexToRemove) {
//                reducedArray[i] = booksInArray[i];
//            } else if (i > indexToRemove) {
//                reducedArray[i - 1] = booksInArray[i];
//            }
//        }
//        System.out.println("\nAu mai ramas in biblioteca urmatoarele titluri:");
//        for (int counter = 0; counter < reducedArray.length; counter++) {
//            System.out.println((counter + 1) + ") " + reducedArray[counter]);
//        }
//
//        // Writes a file containing the list of objects in the array.
//        File arrayInventory = new File("src/ro/sci/resources/Array Library.txt");
//        try (BufferedWriter fileWriter02 = new BufferedWriter(new FileWriter("src/ro/sci/resources/Array Library.txt"))) {
//
//            String arrayToFile = Arrays.toString(reducedArray);
//            String centralizatorCarti02 = arrayToFile.substring(1, arrayToFile.length() - 1);
//            String[] elementeLibrarie02 = centralizatorCarti02.split(",\\s");
//            fileWriter02.write("\nDupa indepartarea din bibilioteca a cartii indicate de user, au mai ramas urmatoarele titluri:\n");
//            int index = 1;
//            for (String e : elementeLibrarie02) {
//                fileWriter02.write("\n~" + String.valueOf(index++) + "~ " + e);
//            }
//
//        } catch (IOException e) {
//            System.out.println("General I/O exception for file: " + arrayInventory.toString());
//        }

        /**
         * =============================Implementing collections using LinkedHashSet ===================================
         */

        System.out.println("\n============ LinkedHashSet<> ============");


        Set<Book> setLibrary = new LinkedHashSet<>();
        setLibrary.add(carte1);
        setLibrary.add(carte2);
        setLibrary.add(carte3);

        /**
         * This object has the same name as carte1. The equals() and hashCode() method implemeted in the Book class
         * ensures that we only find one such object in this LinkedHashSet.
         *
         * {@link #equals(Object()} in Book class.
         * {@link #hashCode()} in Book class.
         */
        setLibrary.add(carte4);

        setLibrary.add(art1);
        setLibrary.add(art2);
        setLibrary.add(art3);

        // Iterate through the collection
        for(Object element: setLibrary){
            System.out.println(element);
        }

        // Verify the presence of an item
        // <<<<<<<<<<<<< Set a scanner >>>>>>>>>>>>>>>
        // <<<<<<<<<<<<< addAll >>>>>>>>>>>
        if(setLibrary.contains(carte2)){
            System.out.println("\nThe library does contain this book.");
        }

    }
}







