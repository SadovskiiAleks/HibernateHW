package com.example.hibernatehw;

import com.example.hibernatehw.repositories.RepositoryImpl;
import com.example.hibernatehw.repositories.entity.Persons;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Repository;

@SpringBootApplication
public class HibernateHwApplication {

//    @PersistenceContext
//    private EntityManager entityManager;

    public static void main(String[] args) {
        SpringApplication.run(HibernateHwApplication.class, args);
//        Persons persons1 = Persons.builder()
//                .name("Sadovskii")
//                .surname("Sasha")
//                .build();
//        entityManager.persist(persons1);
    }

}
