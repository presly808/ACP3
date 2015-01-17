package mountin.JPA;

import javax.persistence.*;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Created by mountin on 21/12/2014.
 */
public class TestOneToMany {

    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("my_unit")
                .createEntityManager();

        //EntityTransaction t = em.getTransaction();

        Agency agency = new Agency();
        agency.setName("super_agency");

        agency.getAuthor().add(new Author("test1", null, true, AuthorType.COMEDY, agency));
        agency.getAuthor().add(new Author("name2", null, true, AuthorType.COMEDY, agency));
        agency.getAuthor().add(new Author("name3", null, true, AuthorType.COMEDY, agency));

        em.getTransaction().begin();
        em.persist(agency);
        em.getTransaction().commit();

    }
}
