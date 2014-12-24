package ua.artcode.week5.day1.jpa;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * Created by User on 21.12.2014.
 */
public class TestLazyInit {
    public static void main(String[] args) {
        EntityManager entityManager =
                Persistence.createEntityManagerFactory("my_unit").createEntityManager();

        Agency agency = entityManager.find(Agency.class,1);

        for(Author author: agency.getAuthors()){
            System.out.println(author);
        }

    }

}
