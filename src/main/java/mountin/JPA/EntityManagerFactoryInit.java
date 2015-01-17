package mountin.JPA;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;

/**
 * Created by mountin on 20/12/2014.
 */
public class EntityManagerFactoryInit {
    public static void main(String[] args) {
        EntityManagerFactory factory =  Persistence.createEntityManagerFactory("my_unit");
        EntityManager em = factory.createEntityManager();

        Author author = new Author("Oleg", new Date(), true, AuthorType.COMEDY);
        em.contains(em);
//        em.getTransaction().begin();
//        em.persist(author);
//        em.getTransaction().commit();

        Author arespond = em.find(Author.class, 1);
        System.out.printf(arespond.toString());

        //em.close();

    }
}
