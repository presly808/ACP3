package ua.artcode.week6.day1.jpa.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Entity Must be POJO
 */
@Entity
@Table(name = "AUTHORS")
public class Author {

    // must have id(primary key)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "author_name", length = 20)
    private String name;

    @Column(name = "births_day")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date birthsDay;

    @Column(name = "is_single")
    private boolean isSingle;

    @Column
    @Enumerated(EnumType.ORDINAL)
    private AuthorType type;

    @ManyToOne
    @JoinColumn(name = "agency_id", referencedColumnName = "id")
    private Agency agency;

    // must have default constructor
    public Author() {

    }

    public Author(String name, Date birthsDay, boolean isSingle, AuthorType type) {
        this.name = name;
        this.birthsDay = birthsDay;
        this.isSingle = isSingle;
        this.type = type;
    }

    public Author(String name, Date birthsDay, boolean isSingle, AuthorType type, Agency agency) {
        this.name = name;
        this.birthsDay = birthsDay;
        this.isSingle = isSingle;
        this.type = type;
        this.agency = agency;
    }

    public Agency getAgency() {
        return agency;
    }

    public void setAgency(Agency agency) {
        this.agency = agency;
    }

    public AuthorType getType() {
        return type;
    }

    public void setType(AuthorType type) {
        this.type = type;
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

    public Date getBirthsDay() {
        return birthsDay;
    }

    public void setBirthsDay(Date birthsDay) {
        this.birthsDay = birthsDay;
    }

    public boolean isSingle() {
        return isSingle;
    }

    public void setSingle(boolean isSingle) {
        this.isSingle = isSingle;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthsDay=" + birthsDay +
                ", isSingle=" + isSingle +
                ", type=" + type +
                '}';
    }
}
