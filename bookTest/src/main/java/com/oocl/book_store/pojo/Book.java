package com.oocl.book_store.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by CHENCO7 on 7/18/2017.
 */
public class Book implements Serializable {
    private Integer id;
    private String name;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date publishDate;
    private String author;
    private Double price;
    private boolean newBook;
    private String publisher;

    public Book() {
    }

    public Book(Integer id, String name, Date publishDate, String author, Double price, boolean newBook, String publisher) {
        this.id = id;
        this.name = name;
        this.publishDate = publishDate;
        this.author = author;
        this.price = price;
        this.newBook = newBook;
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

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
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

    public boolean isNewBook() {
        return newBook;
    }

    public void setNewBook(boolean newBook) {
        this.newBook = newBook;
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
                ", publishDate=" + publishDate +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", newBook=" + newBook +
                ", publisher='" + publisher + '\'' +
                '}';
    }
}
