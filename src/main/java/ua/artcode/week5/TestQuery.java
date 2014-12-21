package ua.artcode.week5;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Yaroslav on 21.12.2014.
 */
public class TestQuery {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("my_unit");
        EntityManager entityManager = factory.createEntityManager();
        Query query = entityManager.createQuery("SELECT a FROM  Author as a where a.name = :name");
        query.setParameter("name", "Hemenguel");
        query.setFirstResult(0);
        query.setMaxResults(0);
        List<Author> authors = query.getResultList();
        for (Author a : authors) {
            System.out.println(a);
        }
    }


}
