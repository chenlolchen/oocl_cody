package com.oocl.book_store.pojo;

import java.util.Date;

/**
 * Created by CHENCO7 on 7/18/2017.
 */
public class Book {
    private Integer id;
    private String name;
    private Date publish_date;
    private String author;
    private Double price;
    private boolean new_book;
    private String publisher;

    public Book() {
    }

    public Book(Integer id, String name, Date publish_date, String author, Double price, boolean new_book, String publisher) {
        this.id = id;
        this.name = name;
        this.publish_date = publish_date;
        this.author = author;
        this.price = price;
        this.new_book = new_book;
        this.publisher = publisher;
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

    public Date getPublish_date() {
        return publish_date;
    }

    public void setPublish_date(Date publish_date) {
        this.publish_date = publish_date;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public boolean isNew_book() {
        return new_book;
    }

    public void setNew_book(boolean new_book) {
        this.new_book = new_book;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", publish_date=" + publish_date +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", new_book=" + new_book +
                ", publisher='" + publisher + '\'' +
                '}';
    }
}
