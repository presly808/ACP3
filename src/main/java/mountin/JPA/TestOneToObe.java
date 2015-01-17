package mountin.JPA;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;

/**
 * Created by mountin on 21/12/2014.
 */
public class TestOneToObe {
    public static void main(String[] args) {
       EntityManager em = Persistence.createEntityManagerFactory("my_unit")
                .createEntityManager();
        Author  author = new Author("Petr", new Date(), true, AuthorType.COMEDY);
        Book book = new Book("man and Sea", 300, 321, author);

        EntityTransaction t = em.getTransaction();

        t.begin();

        //em.persist(author);

        t.commit();
    }
}
