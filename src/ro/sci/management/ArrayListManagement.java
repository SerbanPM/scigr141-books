package ro.sci.management;

import ro.sci.books.ArtAlbum;
import ro.sci.books.Book;
import ro.sci.books.Novel;
import ro.sci.books.SculptureAlbum;
import ro.sci.library.ListLibrary;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

/**
 * <h1>ArrayListManagement</h1>
 * Calls the {@link #addBook(Book carte)} method which is used to add objects to the list.
 * Calls the {@link #getItemCount()} method which is used to count the objects in the list.
 * Calls the {@link #search(String ceCauti)} method which is used to searche for a title in the list.
 * Calls the {@link #remove(Book book)} method which is used to remove objects from the list.
 * Prints the list of objects present in the list.
 * Implements writing a text file containing the list of objects from the list.
 * Implements reading the file and printing the list of objects from the list.
 * Implements reading from keyboard using eighter the name of the object or the
 * position number on the list.
 *
 * @author Serban PM
 * @version 1.0
 * @since 20190122
 */

/**
 * Manages the list of {@link Book} objects.
 */
public class ArrayListManagement {

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


        // Creates an array list with the added objects.
        ListLibrary librarie = new ListLibrary();

        // Adds items to the list.
        librarie.addBook(carte1);
        librarie.addBook(carte2);
        librarie.addBook(carte3);
        librarie.addBook(nuv1);
        librarie.addBook(nuv2);
        librarie.addBook(nuv3);
        librarie.addBook(art1);
        librarie.addBook(art2);
        librarie.addBook(art3);
        librarie.addBook(sculpture1);
        librarie.addBook(sculpture2);
        librarie.addBook(sculpture3);
        librarie.addBook(nuvela);
        librarie.addBook(albumArta);
        librarie.addBook(albumSculptura);

        // Removes intems from the list
        librarie.remove(art2);

        // Writes and prints the item list.
        List cartileDinBiblioteca = librarie.getListOfBooks();
        System.out.println("\n" + cartileDinBiblioteca);

        // Counts and prints the number of the items in the list.
        System.out.println("\nNumar de books existente in biblioteca : " + librarie.getItemCount());

        /**
         * Writes a file containing the list of objects in the library.
         */
        Scanner writeInventory = null;
        File inventory = new File("src/ro/sci/resources/Elemente Librarie.txt");
        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter("src/ro/sci/resources/Elemente Librarie.txt"))) {

            // Creates a string containing the books in the library.
            String listaNeprelucrata = cartileDinBiblioteca.toString();
            // Eliminates the first and the last characters from the string.
            String centralizatorCarti = listaNeprelucrata.substring(1, listaNeprelucrata.length() - 1);
            // Splits the string where a certain pattern is found.
            String[] elementeLibrarie = centralizatorCarti.split(",\\s");
            // Java foreach loop prints the separated elements of the library.
            // Adds position numbers to every element of the library.
            int index = 1;
            for (String e : elementeLibrarie) {
                fileWriter.write("\n~" + String.valueOf(index++) + "~ " + e);
            }

        } catch (IOException e) {
            System.out.println("General I/O exception for file: " + inventory.toString());
        }


        /**
         * Reads the file containing the list of objects in the library.
         */
        Scanner readInventory = null;

        try {
            readInventory = new Scanner(new File("src/ro/sci/resources/Elemente Librarie.txt"));
            while (readInventory.hasNextLine()) {
                System.out.println(readInventory.nextLine());
            }
        } catch (FileNotFoundException e){
            System.out.println("Exception occured: " + e);
        }

        /**
         * Searches for a book using the name inquired by user.
         * Prints the result of the search.
         */
        Scanner keyboard = new Scanner(System.in);
        System.out.println("\nIntroduceti numele cartii cautate: ");
        String mySearch = keyboard.nextLine();
        librarie.search(mySearch);

        /**
         * Searches for a book using the position number inquired by user.
         * Prints the name of the book.
         */
        System.out.println("\nIntroduceti un numarul pozitiei cautate: ");
        int myint = keyboard.nextInt();
        String myString = keyboard.nextLine();
        System.out.println("\nCartea aflata la pozitia ~" + myint + "~ este: ");

        try {
            List<String> allLines = Files.readAllLines(Paths.get("src/ro/sci/resources/Elemente Librarie.txt"));
            String[] arrayLines = allLines.toArray(new String[0]);
            System.out.println(arrayLines[myint]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}










