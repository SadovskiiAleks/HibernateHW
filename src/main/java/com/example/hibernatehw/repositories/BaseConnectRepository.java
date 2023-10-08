package com.example.hibernatehw.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class BaseConnectRepository {

//    @Autowired
//    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @PersistenceContext
    private EntityManager entityManager;
//    private final String sqlFile = "ScriptToFindToName.sql";

    public List getProductName(String name) {
//        String sql = read(sqlFile);
//        final List<String> productsWithNamed = namedParameterJdbcTemplate.queryForList(
//                sql, new MapSqlParameterSource("name", name), String.class);
        return entityManager.createQuery(
//                        "select p.user from Persons p WHERE p.city_of_living LIKE :custCity"
                "select o.product_name from Orders o " +
                        "join Customers c ON c.id = o.customers.id " +
                        "where lower(c.name) = lower(:custName)"
                        )
                .setParameter("custName", name)
                .setMaxResults(10)
                .getResultList();
    }

//    private static String read(String scriptFileName) {
//        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
//             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
//            return bufferedReader.lines().collect(Collectors.joining("\n"));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
}
