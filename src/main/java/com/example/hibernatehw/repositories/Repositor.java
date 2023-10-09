package com.example.hibernatehw.repositories;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Repositor {
    public List getPersonsByCity(String city);
}
