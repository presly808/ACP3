package ua.artcode.week5.day1.jpa.test;

import ua.artcode.week5.day1.jpa.model.Author;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by admin on 20.12.2014.
 */
public class EntityManagerFind {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("my_unit");
        EntityManager entityManager = factory.createEntityManager();

        Author author = entityManager.find(Author.class, 1);
        System.out.println(author);
    }

}
