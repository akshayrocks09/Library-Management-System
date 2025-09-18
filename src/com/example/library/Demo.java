package com.example.library;

import java.util.List;


public class Demo {
    public static void main(String[] args) {
        //  Create a Library instance
        Library library = new Library();

        // Create books using BookFactory
        Book book1 = BookFactory.createBook("9780134685991", "Effective Java", "Joshua Bloch", 2018);
        Book book2 = BookFactory.createBook("9780596009205", "Head First Java", "Kathy Sierra", 2005);
        Book book3 = BookFactory.createBook("9780132350884", "Clean Code", "Robert C. Martin", 2008);

        // NEW: Add another book by the same author to allow recommendations
        Book book4 = BookFactory.createBook("9780137081073", "The Clean Coder", "Robert C. Martin", 2011);

        // Add books to library
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4); // add the new book

        // Create patrons using PatronFactory
        Patron patron1 = PatronFactory.createPatron("P001", "Anika", "anika@email.com");
        Patron patron2 = PatronFactory.createPatron("P002", "Rohan", "rohan@email.com");

        // Add patrons to library
        library.addPatron(patron1);
        library.addPatron(patron2);

        // Checkout a book for Anika
        library.checkoutBook("9780134685991", "P001");

        // Search for books
        System.out.println("\nSearch results for 'Clean':");
        List<Book> searchResults = library.searchByTitle("Clean");
        searchResults.forEach(System.out::println);

        // Return the book for Anika
        library.returnBook("9780134685991", "P001");

        // Checkout and return a book for Rohan (to create history)
        library.checkoutBook("9780132350884", "P002"); // Rohan borrows "Clean Code"
        library.returnBook("9780132350884", "P002");   // Rohan returns it

        //Set recommendation strategy
        library.setRecommendationStrategy(new SimpleHistoryRecommendation());

        // Get and print recommendations for Rohan
        System.out.println("\nRecommendations for Rohan:");
        List<Book> recommendations = library.recommendBooks("P002");
        recommendations.forEach(System.out::println);
    }
}
