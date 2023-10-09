package com.example.hibernatehw.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BaseConnectRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List getProductName(String name) {
        return entityManager.createQuery(
                        "select o.productName from Orders o " +
                                "join Customers c ON c.id = o.customers.id " +
                                "where lower(c.name) = lower(:custName)"
                )
                .setParameter("custName", name)
                .getResultList();
    }
}
