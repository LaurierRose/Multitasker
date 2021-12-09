package com.example.multitasker.module;

public class Book {

    private String title;
    private String author;
    private int released;
    private int column;
    private int row;
    private String summary;
    private String cover;

    public Book(String title, String author, int released, int column, int row, String summary) {
        this.title = title;
        this.author = author;
        this.released = released;
        this.column = column;
        this.row = row;
        this.summary = summary;
        this.cover = null;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return author;
    }

    public String getReleased() {
        return String.valueOf(released);
    }

    public String getColumn() {
        return String.valueOf(column);
    }

    public String getRow() {
        return String.valueOf(row);
    }

    public String getSummary() {
        return summary;
    }

    public String getCover() {
        return cover;
    }
}