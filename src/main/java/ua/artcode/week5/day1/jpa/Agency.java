package ua.artcode.week5.day1.jpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 21.12.2014.
 */
@Entity
@Table(name = "agences")
public class Agency extends AutoGenerateIdentity{
    private String name;

    public Agency() {
    }

    //List, Set, Map when OneToMany or ManyToOne

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, mappedBy = "agency")
    List<Author> authors = new ArrayList<Author>();

    public String getName() {
        return name;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setName(String name) {

        this.name = name;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }
}
