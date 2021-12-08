package com.example.multitasker.module;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Library {

    private ObservableList<Book> books;

    public Library() {
        this.books = FXCollections.observableArrayList();
        this.books.add(new Book("The Shining", "Stephen King", 1977, 2, 3, "Jack Torrance becomes winter caretaker at the isolated Overlook Hotel in Colorado, hoping to cure his writer's block."));
    }

    public void add(String[] fields, int released, int column, int row) {
        this.books.add(new Book(fields[0], fields[1], released, column, row, fields[5]));
    }

    public ObservableList<Book> getBooks() {
        return books;
    }

    public void setBooks(ObservableList<Book> books) {
        this.books = books;
    }
}