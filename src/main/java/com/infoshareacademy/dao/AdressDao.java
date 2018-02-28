package com.infoshareacademy.dao;

import com.infoshareacademy.model.Adress;
import com.infoshareacademy.model.Computer;
import com.infoshareacademy.model.Student;

import javax.ejb.Stateless;
import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Stateless
public class AdressDao {

    @PersistenceContext
    private EntityManager entityManager;



    public Long save(Adress a) {
        entityManager.persist(a);
        return a.getId();
    }

    public Adress update(Adress a) {
        return entityManager.merge(a);
    }

    public void delete(Long id) {
        final Adress a = entityManager.find(Adress.class, id);
        if (a != null) {
            entityManager.remove(a);
        }
    }

    public Adress findById(Long id) {
        return entityManager.find(Adress.class, id);
    }

    public List<Adress> findAll() {
        final Query query = entityManager.createQuery("SELECT a FROM Adress a");

        return query.getResultList();
    }
}
