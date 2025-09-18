package com.example.library;


public class PatronFactory {


    public static Patron createPatron(String id, String name, String email) {
        return new Patron(id, name, email);
    }
}
