package ua.artcode.week5.day1.jpa;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by User on 21.12.2014.
 */
public class TestJPQL {
    public static void main(String[] args) {
        EntityManager entityManager =
                Persistence.createEntityManagerFactory("my_unit").createEntityManager();

//        Query query = entityManager.createQuery
//                              ("select a from Author as a where a.name = :name");
//
//        query.setParameter("name","Ivanov");
//        query.setFirstResult(0);
//        query.setMaxResults(10);

        Query query = entityManager.createQuery
                ("select a from Author as a where a.name = :name AND a.agency.name = :agency_name")
                .setParameter("name", "Ivanov")
                .setParameter("agency_name","SUPER_AGENCY")
                .setFirstResult(0)
                .setMaxResults(10);


        List<Author> authorList = query.getResultList();
        for(Author author: authorList){
            System.out.println(author.getId());
        }

    }
}
