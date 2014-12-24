package ua.artcode.week5.day1.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Created by User on 21.12.2014.
 */
public class TestOneToOne {
    public static void main(String[] args) {
        EntityManager entityManager =
                Persistence.createEntityManagerFactory("my_unit").createEntityManager();

        Author heminguey = new Author("Heminguey",null,false,AuthorType.NOVELL);
        Book book = new Book("Man and Sea",300,2,heminguey);

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        //entityManager.persist(heminguey);
        entityManager.persist(book);
        transaction.commit();

    }
}
