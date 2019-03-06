package ro.sci.library;

import ro.sci.books.Book;

public class ArrayLibrary {
    public static void main(String[] args){
        Book[][] blabla = new Book[4][3];
        System.out.println(blabla[0][1]);

        for (int row = 0; row < blabla.length; row++) {
            for (int col = 0; col < blabla[row].length; col++) {
                // System.out.println(blabla[row][col]);
                System.out.print(blabla[row][col] + "\t");
            }
            System.out.println();
        }
    }
}
