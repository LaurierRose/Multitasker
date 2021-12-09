package com.example.multitasker.module;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Library {

    private ObservableList<Book> books;
    private ObservableList<Book> results;

    public Library() {
        this.books = FXCollections.observableArrayList();
        this.results = FXCollections.observableArrayList();
        this.books.add(new Book("The Shining", "Stephen King", 1977, 2, 3,
                "Jack Torrance becomes winter caretaker at the isolated Overlook Hotel in Colorado, hoping to cure his writer's block.",
                "https://images-na.ssl-images-amazon.com/images/I/51jSPyJ8v2L._SX302_BO1,204,203,200_.jpg"));
        this.books.add(new Book("Harry Potter and the Philosopher's Stone", "J. K. Rowling", 1997,
                1, 4, "An orphan is brought up by his aunt and uncle because his parents were killed when he was a baby.",
                "https://res.cloudinary.com/bloomsbury-atlas/image/upload/w_360,c_scale/jackets/9781408855652.jpg"));
        this.books.add(new Book("The Hitchhiker's Guide to the Galaxy", "Douglas Adams", 1979,
                1, 4, "Ford is a cleverly disguised alien, who has been stranded on Earth for the" +
                "past 15 years as he writes a revised guide to the galaxy."));
    }

    public void add(String[] fields, int released, int column, int row) {
        this.books.add(new Book(fields[0], fields[1], released, column, row, fields[5]));
    }

    public void add(String[] fields, int released, int column, int row, String url) {
        this.books.add(new Book(fields[0], fields[1], released, column, row, fields[5], url));
    }

    public void remove(Book obj) {
        this.books.remove(obj);
    }

    public ObservableList<Book> getBooks() {
        return books;
    }

    public ObservableList<Book> search(String search) {
        results.clear();
        for (Book i : this.books) {
            if (i.contains(search)) {
                results.add(i);
            }
        }
        return results;
    }
}