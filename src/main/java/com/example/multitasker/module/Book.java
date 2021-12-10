package com.example.multitasker.module;

import java.util.Objects;

public class Book {

    private String title;
    private String author;
    private int released;
    private int column;
    private int row;
    private String summary;
    private String cover;


    public Book(String title, String author, int released, int column, int row, String summary, String cover) {
        this.title = title;
        this.author = author;
        this.released = released;
        this.column = column;
        this.row = row;
        this.summary = summary;
        this.cover = cover;
    }

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

    public void setCover(String url) {
        this.cover = url;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setReleased(int released) {
        this.released = released;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (released != book.released) return false;
        if (!Objects.equals(title, book.title)) return false;
        return Objects.equals(author, book.author);
    }

    public boolean contains(String search)  {
        String cleanSearch = search.toLowerCase().trim();
        return this.getTitle().toLowerCase().contains(cleanSearch) || this.getAuthor().toLowerCase().contains(cleanSearch);
    }
}
