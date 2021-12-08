package com.example.multitasker.module;

import java.util.ArrayList;

public class Library {

    private ArrayList<Book> library;

    public Library() {
        this.library = new ArrayList<>();
    }

    public void add(String[] fields, int released, int column, int row) {
        this.library.add(new Book(fields[0], fields[1], released, column, row, fields[5]));
    }
}