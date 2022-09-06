package com.example.myprovidertest;

public class Book {
    private Integer id;
    private String name;
    private String author;
    private int pages;
    private double prices;


    public Book(Integer id, String name, String author, int pages, double prices) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.pages = pages;
        this.prices = prices;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public double getPrices() {
        return prices;
    }

    public void setPrices(double prices) {
        this.prices = prices;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", pages=" + pages +
                ", prices=" + prices +
                '}';
    }
}
