package com.example.library;

import java.util.Objects;

public class Book {
    private final String isbn;     // unique identifier
    private String title;
    private String author;
    private int publicationYear;

    // Constructor
    public Book(String isbn, String title, String author, int publicationYear) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    // Getters
    public String getIsbn() { return isbn; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getPublicationYear() { return publicationYear; }

    // Setters (can update all except ISBN)
    public void setTitle(String title) { this.title = title; }
    public void setAuthor(String author) { this.author = author; }
    public void setPublicationYear(int publicationYear) { this.publicationYear = publicationYear; }

    // Equals & hashCode (based only on ISBN)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return isbn.equals(book.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }

    // String representation
    @Override
    public String toString() {
        return String.format("%s (ISBN: %s) by %s [%d]",
                title, isbn, author, publicationYear);
    }
}
