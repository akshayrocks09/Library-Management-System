package com.example.library;

import java.util.*;


public class SimpleHistoryRecommendation implements RecommendationStrategy {

    @Override
    public List<Book> recommend(String patronId, Library library) {
        Patron patron = library.getPatron(patronId);
        if (patron == null) return Collections.emptyList();

        // Collect authors the patron has borrowed
        Set<String> authorsRead = new HashSet<>();
        for (Loan loan : patron.getBorrowingHistory()) {
            library.searchByIsbn(loan.getIsbn())
                    .ifPresent(book -> authorsRead.add(book.getAuthor()));
        }

        // Recommend books by same authors that patron has NOT borrowed
        List<Book> recommendations = new ArrayList<>();
        for (Book book : library.allBooks()) {
            if (authorsRead.contains(book.getAuthor())) {
                boolean alreadyBorrowed = patron.getBorrowingHistory().stream()
                        .anyMatch(loan -> loan.getIsbn().equals(book.getIsbn()));
                if (!alreadyBorrowed) {
                    recommendations.add(book);
                }
            }
        }

        return recommendations;
    }
}
