package ua.artcode.week5.day1.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;

/**
 * Created by User on 20.12.2014.
 */
public class EntityManagerFindTest {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("my_unit");
        EntityManager entityManager = factory.createEntityManager();

        Author author = entityManager.find(Author.class, 1);
        System.out.println(author);
    }
}
