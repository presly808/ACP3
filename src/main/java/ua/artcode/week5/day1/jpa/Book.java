package ua.artcode.week5.day1.jpa;

import javax.persistence.*;

/**
 * Created by User on 21.12.2014.
 */

@Entity
@Table
public class Book {
    public Book(String name, int page, int innerId, Author author) {
        this.name = name;
        this.page = page;
        this.innerId = innerId;
        this.author = author;
    }

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int page;

    @Transient
    private int innerId;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public int getId() {

        return id;
    }

    public String getName() {
        return name;
    }

    public int getPage() {
        return page;
    }

    public Author getAuthor() {
        return author;
    }

    public Book() {

    }


    @OneToOne(cascade = CascadeType.PERSIST)
    private Author author;

}
