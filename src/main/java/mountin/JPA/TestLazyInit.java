package mountin.JPA;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * Created by mountin on 21/12/2014.
 */
public class TestLazyInit {
    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("my_unit")
                .createEntityManager();

        Agency agency = em.find(Agency.class, 1);


        for(Author author: agency.getAuthor()){
            System.out.println(author);
        }
    }
}
