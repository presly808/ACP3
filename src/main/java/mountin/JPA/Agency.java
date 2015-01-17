package mountin.JPA;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mountin on 21/12/2014.
 */
@Entity
@Table(name = "agency")
public class Agency extends AutoGeneratedIndety{
    public Agency(String name, List<Author> author) {
        this.name = name;
        this.author = author;
    }

    public Agency() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Author> getAuthor() {
        return author;
    }

    public void setAuthor(List<Author> author) {
        this.author = author;
    }

    @Column(name = "agency_name", length=20)
    private String name;


    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, mappedBy = "agency")
    List<Author> author = new ArrayList<>();

}
