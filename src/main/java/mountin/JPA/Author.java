package mountin.JPA;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by mountin on 20/12/2014.
 */
@Entity
@Table(name= "AUTHORS")
public class Author {
    //must have id (primary key)
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name = "author_name", length=20)
    private String name;

    @ManyToOne
    @JoinColumn(name = "agency_id", referencedColumnName = "id")
    private Agency agency;

    @Temporal(TemporalType.TIMESTAMP)
    private Date buthDay;

    @Column(name = "yes")
    private boolean isSingle;

    @Enumerated(EnumType.ORDINAL)
    private AuthorType type;

    public Author() {
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", buthDay=" + buthDay +
                ", isSingle=" + isSingle +
                ", type=" + type +
                '}';
    }

    public AuthorType getType() {
        return type;
    }

    public void setType(AuthorType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getButhDay() {
        return buthDay;
    }

    public void setButhDay(Date buthDay) {
        this.buthDay = buthDay;
    }

    public boolean isSingle() {
        return isSingle;
    }

    public void setSingle(boolean isSingle) {
        this.isSingle = isSingle;
    }

    public Author(String name, Date buthDay, boolean isSingle, AuthorType type) {
        this.name = name;
        this.buthDay = buthDay;
        this.isSingle = isSingle;
        this.type = type;


    }
    public Author(String name, Date buthDay, boolean isSingle, AuthorType type, Agency agency) {
        this.name = name;
        this.buthDay = buthDay;
        this.isSingle = isSingle;
        this.type = type;
        this.agency = agency;
    }

}
