package ua.artcode.week5.day1.jpa;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Created by User on 21.12.2014.
 */
@MappedSuperclass
public class AutoGenerateIdentity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public AutoGenerateIdentity() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {

        return id;
    }


}
