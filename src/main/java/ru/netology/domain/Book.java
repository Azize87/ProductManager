package ru.netology.domain;

public class Book extends Product {
    private String author;

    public Book(int id, String tatle, int price, String author) {
        super(id, tatle, price);
        this.author = author;

    }

    public String getAuthor() {
        return author;
    }
}


