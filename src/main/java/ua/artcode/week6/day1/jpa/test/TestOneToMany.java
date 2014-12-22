package ua.artcode.week6.day1.jpa.test;

import ua.artcode.week6.day1.jpa.model.Agency;
import ua.artcode.week6.day1.jpa.model.Author;
import ua.artcode.week6.day1.jpa.model.AuthorType;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * Created by admin on 21.12.2014.
 */
public class TestOneToMany {

    public static void main(String[] args) {
        EntityManager entityManager =
                Persistence.createEntityManagerFactory("my_unit")
                        .createEntityManager();


        Agency agency = new Agency();
        agency.setName("SUPER_AGENCY");

        agency.getAuthors().add(new Author("Anatoliy", null, true, AuthorType.COMEDY, agency));
        agency.getAuthors().add(new Author("Serhii", null, true, AuthorType.FANTASY, agency));
        agency.getAuthors().add(new Author("Oleg", null, true, AuthorType.NOVEL, agency));

        entityManager.getTransaction().begin();
        entityManager.persist(agency);
        entityManager.getTransaction().commit();

    }

}
