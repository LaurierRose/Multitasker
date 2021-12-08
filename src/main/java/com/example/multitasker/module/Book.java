package com.example.multitasker.module;

public class Book {

    private String title;
    private String author;
    private int released;
    private int[] location;
    private String summary;
    private String cover;

    public Book(String title, String author, int released, int column, int row, String summary) {
        this.title = title;
        this.author = author;
        this.released = released;
        this.location[0] = column;
        this.location[1] = row;
        this.summary = summary;
        this.cover = null;
    }
}