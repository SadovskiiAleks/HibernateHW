package com.example.hibernatehw.repositories;

import com.example.hibernatehw.repositories.entity.Persons;
import com.example.hibernatehw.repositories.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositoryImpl implements Repositor {

    @PersistenceContext
    private EntityManager entityManager;

    public List getPersonsByCity(String city) {
        return entityManager.createQuery(
                        "select p.user from Persons p WHERE p.cityOfLiving LIKE :custCity")
                .setParameter("custCity", city)
                .getResultList();

    }

    public List getUserByName(String name){
        return entityManager.createQuery(
                        "select p.user from Persons p WHERE p.user.name LIKE :custName")
                .setParameter("custName", name)
                .getResultList();
    }

    @Transactional
    public boolean addNewUser(String name, String surname) {
        entityManager.createNativeQuery("INSERT INTO Persons VALUES (?,?,?,?,?)")
                .setParameter(1, name)
                .setParameter(2, surname)
                .setParameter(3, 25)
                .setParameter(4, 2550)
                .setParameter(5, "Spb")
                .executeUpdate();
        return true;
    }

    @Transactional
    public boolean deleteUser(String name, String surname) {
        entityManager.createQuery("delete from Persons p where p.user.name = :castName and p.user.surname = :castSurname")
                .setParameter("castName", name)
                .setParameter("castSurname", surname)
                .executeUpdate();
        return true;
    }
}
