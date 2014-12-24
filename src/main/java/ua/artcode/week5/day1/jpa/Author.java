package ua.artcode.week5.day1.jpa;

import javax.persistence.*;
import java.util.Date;

/**
 * Entuity must be POJO
 */

@Entity
@Table(name="AUTHORS")
public class Author {
    //must have id(primary key)
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name = "author_name")
    private String name;

    @Column(name = "births_day")
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthsDay;

    @Column(name = "yes")
    private boolean isSingle;

    @Column
    @Enumerated(EnumType.ORDINAL)
    private AuthorType type;

    public Author(String name, Date birthsDay, boolean isSingle, AuthorType type, Agency agency) {
        this.name = name;
        this.birthsDay = birthsDay;
        this.isSingle = isSingle;
        this.type = type;
        this.agency = agency;
    }

    @ManyToOne
    @JoinColumn(name = "agency_id", referencedColumnName = "id")
    private Agency agency;

    public Author() {
    }

    public Author(String name, Date birthsDay, boolean isSingle, AuthorType type) {
        this.name = name;
        this.birthsDay = birthsDay;
        this.isSingle = isSingle;
        this.type= type;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthsDay(Date birthsDay) {
        this.birthsDay = birthsDay;
    }

    public void setSingle(boolean isSingle) {
        this.isSingle = isSingle;
    }

    public int getId() {

        return id;
    }

    public String getName() {
        return name;
    }

    public Date getBirthsDay() {
        return birthsDay;
    }

    public boolean isSingle() {
        return isSingle;
    }


}
