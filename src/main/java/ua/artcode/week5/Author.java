package ua.artcode.week5;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Yaroslav on 20.12.2014.
 */
@Entity
@Table(name = "AUTHORS")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "author_name",length = 20)
    private String name;

    @Column
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date bithDay;

    @Column(name = "is_single")
    private boolean isSingle;

    @Column
    @Enumerated(EnumType.ORDINAL)
    AuthorType authorType;

    @ManyToOne
    @JoinColumn(name = "agency_id",referencedColumnName = "id")
    private PublishAgency agency;

    public AuthorType getAuthorType() {
        return authorType;
    }


    public Author(String name, Date bithDay, boolean isSingle, AuthorType authorType, PublishAgency agency) {
        this.name = name;
        this.bithDay = bithDay;
        this.isSingle = isSingle;
        this.authorType = authorType;
        this.agency = agency;
    }

    public void setAuthorType(AuthorType authorType) {
        this.authorType = authorType;
    }

    public Author() {
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

    public Date getBithDay() {
        return bithDay;
    }

    public void setBithDay(Date bithDay) {
        this.bithDay = bithDay;
    }

    public boolean isSingle() {
        return isSingle;
    }

    public void setSingle(boolean isSingle) {
        this.isSingle = isSingle;
    }

    public PublishAgency getAgency() {
        return agency;
    }

    public void setAgency(PublishAgency agency) {
        this.agency = agency;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", bithDay=" + bithDay +
                ", isSingle=" + isSingle +
                ", authorType=" + authorType +
                '}';
    }
}
