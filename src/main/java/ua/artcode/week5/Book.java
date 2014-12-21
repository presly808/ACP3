package ua.artcode.week5;

import javax.persistence.*;

/**
 * Created by Yaroslav on 21.12.2014.
 */

@Entity
@Table(name = "BOOKS")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Transient
    private int test;

    private int pages;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Author author;

    public Book() {
    }



    public Book(String name, int test, int pages, Author author) {
        this.name = name;
        this.test = test;
        this.pages = pages;
        this.author = author;
    }

    public int getTest() {
        return test;
    }

    public void setTest(int test) {
        this.test = test;
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
}
