package ua.artcode.week5;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;

/**
 * Created by Yaroslav on 21.12.2014.
 */
public class TestOneToMany {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("my_unit");
        EntityManager entityManager = factory.createEntityManager();

        PublishAgency agency = new PublishAgency();
        agency.setName("XXX");
        Author author = new Author("Hemenguel", new Date(), true, AuthorType.COMEDY, agency);
        Author author1 = new Author("Hemenguel1", new Date(), true, AuthorType.COMEDY, agency);
        Book book = new Book("Test", 1, 200, author);

        agency.getAuthors().add(author);
        agency.getAuthors().add(author1);

        entityManager.getTransaction().begin();
        entityManager.persist(agency);
        entityManager.getTransaction().commit();
    }
}
