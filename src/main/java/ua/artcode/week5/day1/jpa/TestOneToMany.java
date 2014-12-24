package ua.artcode.week5.day1.jpa;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * Created by User on 21.12.2014.
 */
public class TestOneToMany {
    public static void main(String[] args) {
        EntityManager entityManager =
                Persistence.createEntityManagerFactory("my_unit").createEntityManager();

        Agency agency = new Agency();
        agency.setName("SUPER_AGENCY");

        agency.getAuthors().add(new Author("Anatoly",null,false,AuthorType.COMEDY,agency));
        agency.getAuthors().add(new Author("Petrov",null,false,AuthorType.DETECTIVE,agency));
        agency.getAuthors().add(new Author("Ivanov",null,false,AuthorType.FANTASY,agency));
        agency.getAuthors().add(new Author("Sidorov",null,false,AuthorType.NOVELL,agency));

        entityManager.getTransaction().begin();
        entityManager.persist(agency);
        entityManager.getTransaction().commit();

    }

}
