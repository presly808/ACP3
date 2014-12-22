package ua.artcode.week6.day1.jpa.model;

import javax.persistence.*;

/**
 *
 */
@Entity
@Table(name = "BOOKS")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private int pages;

    @Transient
    private int innerId;


    @OneToOne(cascade = CascadeType.PERSIST)
    private Author author;

    public Book() {
    }

    public Book(String name, int pages, int innerId, Author author) {
        this.name = name;
        this.pages = pages;
        this.innerId = innerId;
        this.author = author;
    }

    public int getInnerId() {
        return innerId;
    }

    public void setInnerId(int innerId) {
        this.innerId = innerId;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }



    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pages=" + pages +
                '}';
    }
}
