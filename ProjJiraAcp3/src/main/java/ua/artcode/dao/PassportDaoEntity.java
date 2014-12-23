package ua.artcode.dao;

import ua.artcode.db.EntityFactoryJira;
import ua.artcode.model.Passport;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Yaroslav on 23.12.2014.
 */
public class PassportDaoEntity {
    EntityManager entityManager = EntityFactoryJira.getInstance();

    public void AddPassport(Passport passport) {
        entityManager.getTransaction().begin();
        entityManager.persist(passport);
        entityManager.getTransaction().commit();
    }

    public Passport GetPassport(String log, String pass) {
        Query query = entityManager.createQuery("SELECT p FROM Passport as p where p.login = :log and  p.pass = :pass");
        query.setParameter("log", log);
        query.setParameter("pass", pass);

        List<Passport> list = query.getResultList();

        return list.size()>0 ? list.get(0):null;
    }
}
