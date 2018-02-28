package com.infoshareacademy.dao;

import com.infoshareacademy.model.Computer;
import com.infoshareacademy.model.Student;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class ComputerDao {

    @PersistenceContext
    private EntityManager entityManager;

    public Long save(Computer computer) {
        entityManager.persist(computer);
        return computer.getId();
    }

    public Computer update(Computer computer) {
        return entityManager.merge(computer);
    }

    public void delete(Long id) {
        final Computer computer = entityManager.find(Computer.class, id);
        if (computer != null) {
            entityManager.remove(computer);
        }
    }

    public Computer findById(Long id) {
        return entityManager.find(Computer.class, id);
    }

    public List<Computer> findAll() {
        final Query query = entityManager.createQuery("SELECT computer FROM Computer computer");

        return query.getResultList();
    }

}
