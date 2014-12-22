package ua.artcode.week6.day1.jpa.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
@Entity
@Table(name = "agencies")
public class Agency extends AutoGeneratedIdentity {

    private String name;

    // List, Set, Map when OneToMany or ManyToMany

    //@LazyCollection(LazyCollectionOption.TRUE)
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "agency")
    List<Author> authors = new ArrayList<>();

    public Agency() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }
}