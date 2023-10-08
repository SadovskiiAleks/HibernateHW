//package com.example.hibernatehw.repositories;
//
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.PersistenceContext;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public class RepositoryImpl implements Repositor {
//
//    @PersistenceContext
//    private EntityManager entityManager;
//
//    public List getPersonsByCity(String city) {
//        return entityManager.createQuery(
//                        "select p.user from Persons p WHERE p.city_of_living LIKE :custCity")
//                .setParameter("custCity", city)
//                .setMaxResults(10)
//                .getResultList();
//
//    }
//}
