package com.example.hibernatehw.repositories.entity;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Data
@Embeddable
public class User implements Serializable {
    private String name;
    private String surname;
    private int age;
}
