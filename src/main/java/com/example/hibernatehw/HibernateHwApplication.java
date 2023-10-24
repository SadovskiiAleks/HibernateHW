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

    public static void main(String[] args) {
        SpringApplication.run(HibernateHwApplication.class, args);
    }

}
