package mountin.JPA;


import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by mountin on 21/12/2014.
 */
public class TestJPQL
{
    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("my_unit")
                .createEntityManager();

        Query q =  em.createQuery("select a from Author as a where a.name= :name AND a.agency.name = :agency_name")
                .setParameter("name", "Test1")
                .setParameter("agency_name", "super_agency")
                .setFirstResult(0)
                .setMaxResults(10);



        List<Author> asd = q.getResultList();
        for(Author author: asd){
            System.out.println(author);
        }

    }
}
