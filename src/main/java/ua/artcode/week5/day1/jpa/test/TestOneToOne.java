package ua.artcode.week5.day1.jpa.test;

import ua.artcode.week5.day1.jpa.model.Author;
import ua.artcode.week5.day1.jpa.model.AuthorType;
import ua.artcode.week5.day1.jpa.model.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Created by admin on 21.12.2014.
 */
public class TestOneToOne {

    public static void main(String[] args) {
        EntityManager entityManager =
                Persistence.createEntityManagerFactory("my_unit")
                        .createEntityManager();

        Author hemenguey = new Author("Hemenguey", null, false, AuthorType.NOVEL, null);
        Book book = new Book("Man and Sea", 300, 2, hemenguey);

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(book);
        transaction.commit();
    }
}
