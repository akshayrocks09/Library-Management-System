package com.example.library;

import java.util.*;


public class Library {
    private final Map<String, Book> books;          // key = ISBN
    private final Map<String, Patron> patrons;      // key = Patron ID
    private final Map<String, String> borrowed;     // key = ISBN, value = Patron ID

    private RecommendationStrategy recommendationStrategy;

    public Library() {
        this.books = new HashMap<>();
        this.patrons = new HashMap<>();
        this.borrowed = new HashMap<>();
    }


    // Book Management

    public void addBook(Book book) {
        if (!books.containsKey(book.getIsbn())) {
            books.put(book.getIsbn(), book);
            System.out.println("Book added: " + book);
        } else {
            System.out.println("Book already exists: " + book.getIsbn());
        }
    }

    public void removeBook(String isbn) {
        Book removed = books.remove(isbn);
        if (removed != null) {
            System.out.println("Book removed: " + removed);
        } else {
            System.out.println("No book found with ISBN " + isbn);
        }
    }

    public Optional<Book> searchByIsbn(String isbn) {
        return Optional.ofNullable(books.get(isbn));
    }

    public List<Book> searchByTitle(String title) {
        List<Book> result = new ArrayList<>();
        for (Book book : books.values()) {
            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                result.add(book);
            }
        }
        return result;
    }

    public List<Book> searchByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book book : books.values()) {
            if (book.getAuthor().toLowerCase().contains(author.toLowerCase())) {
                result.add(book);
            }
        }
        return result;
    }

    public Collection<Book> allBooks() {
        return books.values();
    }


    // Patron Management

    public void addPatron(Patron patron) {
        if (!patrons.containsKey(patron.getId())) {
            patrons.put(patron.getId(), patron);
            System.out.println("Patron added: " + patron);
        } else {
            System.out.println("Patron already exists: " + patron.getId());
        }
    }

    public Patron getPatron(String patronId) {
        return patrons.get(patronId);
    }


    // Lending Process

    public void checkoutBook(String isbn, String patronId) {
        if (!books.containsKey(isbn)) {
            System.out.println("Book not found.");
            return;
        }
        if (!patrons.containsKey(patronId)) {
            System.out.println("Patron not found.");
            return;
        }
        if (borrowed.containsKey(isbn)) {
            System.out.println("Book is already borrowed.");
            return;
        }

        borrowed.put(isbn, patronId);
        Patron patron = patrons.get(patronId);
        patron.addLoan(new Loan(isbn, new Date(), null));
        System.out.println("Book checked out: " + books.get(isbn) + " to " + patron);
    }

    public void returnBook(String isbn, String patronId) {
        if (!borrowed.containsKey(isbn)) {
            System.out.println("Book is not borrowed.");
            return;
        }
        if (!borrowed.get(isbn).equals(patronId)) {
            System.out.println("This book was not borrowed by patron " + patronId);
            return;
        }

        borrowed.remove(isbn);
        Patron patron = patrons.get(patronId);
        patron.completeLoan(isbn);
        System.out.println("Book returned: " + books.get(isbn));
    }


    // Recommendation System

    public void setRecommendationStrategy(RecommendationStrategy strategy) {
        this.recommendationStrategy = strategy;
    }

    public List<Book> recommendBooks(String patronId) {
        if (recommendationStrategy == null) {
            System.out.println("No recommendation strategy set.");
            return Collections.emptyList();
        }
        return recommendationStrategy.recommend(patronId, this);
    }
}
