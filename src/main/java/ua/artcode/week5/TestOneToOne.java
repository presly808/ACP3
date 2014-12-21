package ua.artcode.week5;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;

/**
 * Created by Yaroslav on 21.12.2014.
 */
public class TestOneToOne {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("my_unit");
        EntityManager entityManager = factory.createEntityManager();

        Author author = new Author("Hemenguel", new Date(), true, AuthorType.COMEDY,null);
        Book book = new Book("Test", 1, 200, author);

        entityManager.getTransaction().begin();
        entityManager.persist(book);
        entityManager.getTransaction().commit();
    }
}
