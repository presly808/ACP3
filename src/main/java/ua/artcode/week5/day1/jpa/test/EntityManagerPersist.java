package ua.artcode.week5.day1.jpa.test;

import ua.artcode.week5.day1.jpa.model.Author;
import ua.artcode.week5.day1.jpa.model.AuthorType;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;

/**
 * Created by admin on 20.12.2014.
 */
public class EntityManagerPersist {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("my_unit");
        EntityManager entityManager = factory.createEntityManager();

        Author author = new Author("Oleg", new Date(), true, AuthorType.COMEDY);
        entityManager.getTransaction().begin();
        entityManager.persist(author);
        entityManager.getTransaction().commit();



    }

}
