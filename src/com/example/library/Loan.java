package com.example.library;

import java.util.Date;


public class Loan {
    private final String isbn;       // ISBN of the borrowed book
    private final Date checkoutDate; // when the book was borrowed
    private Date returnDate;         // when the book was returned

    // Constructor
    public Loan(String isbn, Date checkoutDate, Date returnDate) {
        this.isbn = isbn;
        this.checkoutDate = checkoutDate;
        this.returnDate = returnDate;
    }

    // Getters
    public String getIsbn() {
        return isbn;
    }

    public Date getCheckoutDate() {
        return checkoutDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    // Mark book as returned
    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    // Check if loan is active (not returned yet)
    public boolean isActive() {
        return returnDate == null;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "ISBN='" + isbn + '\'' +
                ", checkout=" + checkoutDate +
                ", returned=" + returnDate +
                '}';
    }
}
