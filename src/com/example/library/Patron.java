package com.example.library;

import java.util.ArrayList;
import java.util.List;


public class Patron {
    private final String id;          // unique patron ID
    private String name;
    private String email;

    private final List<Loan> borrowingHistory;  // list of loans (past and active)

    // Constructor
    public Patron(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.borrowingHistory = new ArrayList<>();
    }

    // Getters
    public String getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public List<Loan> getBorrowingHistory() { return borrowingHistory; }

    // Setters
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }

    // ========================
    // Borrowing Management
    // ========================
    /**
     * Add a new loan to the patron's borrowing history.
     */
    public void addLoan(Loan loan) {
        borrowingHistory.add(loan);
    }

    /**
     * Mark a loan as completed (returned) based on ISBN.
     */
    public void completeLoan(String isbn) {
        for (Loan loan : borrowingHistory) {
            if (loan.getIsbn().equals(isbn) && loan.isActive()) {
                loan.setReturnDate(new java.util.Date());
                break;
            }
        }
    }

    @Override
    public String toString() {
        return name + " (ID: " + id + ")";
    }
}
