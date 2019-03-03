package ro.sci.library;

import ro.sci.books.Book;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Library {

    private List<Book> listOfBooks;
    private int numberOfItemsInLibrary;

    public List<Book> getListOfBooks( ){
        return this.listOfBooks;
    }

    public void setListOfBooks(List<Book> listOfBooks){
        this.listOfBooks = listOfBooks;
    }

    public Library( ){
        listOfBooks = new ArrayList<>();
    }

    public void addBook(Book carte){
        listOfBooks.add(carte);
    }

    //mumara articolele din biblioteca
    public int getItemCount( ){
        int itemCount = listOfBooks.size();
        return itemCount;
    }

    //functia de cautare a unui titlu in biblioteca
    public Book search(String ceCauti){
        for (Book carte : listOfBooks) {
            if (ceCauti.equals(carte.getNume())) {
                System.out.println("Cartea cu titlul " + '\'' + ceCauti + '\'' + " exista in aceasta biblioteca!");
                return carte;
            }
        }
        System.out.println("Cartea cu titlul " + '\'' + ceCauti + '\'' + " nu exista in aceasta bilioteca!");
        return null;
    }

    public void removeAllBooksWithName(String numeCarte){
        Iterator<Book> it = listOfBooks.iterator();
        Book book;
        while (it.hasNext()) {
            book = it.next();
            if (book.getNume().equals(numeCarte)) {
                it.remove();
            }
        }
    }

    public void remove(Book book){
        listOfBooks.remove(book);
    }


}











