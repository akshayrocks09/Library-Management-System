package com.example.library;

import java.util.List;


public interface RecommendationStrategy {


    List<Book> recommend(String patronId, Library library);
}
