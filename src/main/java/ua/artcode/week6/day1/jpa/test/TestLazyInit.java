package ua.artcode.week6.day1.jpa.test;

import ua.artcode.week6.day1.jpa.model.Agency;
import ua.artcode.week6.day1.jpa.model.Author;
import ua.artcode.week6.day1.jpa.model.AuthorType;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * TODO test lazy
 */
public class TestLazyInit {

    public static void main(String[] args) {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("my_unit");

        int id = initData(factory);

        EntityManager entityManager = factory.createEntityManager();

        Agency agency = (Agency) entityManager
                .createQuery("select a from Agency a where a.id = :id")
                .setParameter("id", id)
                .getSingleResult();


        for(Author author : agency.getAuthors()){//in this moment performs lazy loading, when we try try open reference in debug(reference panel) - list init
            System.out.println(author);
        }
    }

    public static int initData(EntityManagerFactory factory){
        EntityManager entityManager =
                factory.createEntityManager();

        Agency agency = new Agency();
        agency.setName("AGENCY_LAZY");

        for(int i = 0; i < 1000; i++){
            agency.getAuthors().add(new Author(String.valueOf(i),null,true, AuthorType.COMEDY, agency));
        }

        entityManager.getTransaction().begin();
        entityManager.persist(agency);
        entityManager.getTransaction().commit();
        entityManager.close();
        return agency.getId();
    }

}
