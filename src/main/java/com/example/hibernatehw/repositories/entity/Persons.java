package com.example.hibernatehw.repositories.entity;


import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
@Builder
@Table( name = "Persons",
        catalog = "test",
        schema = "public")
public class Persons {

    @EmbeddedId
    private User user;

    @Column(name = "phone_number")
    private int phoneNumber;

    @Column(name = "city_of_living")
    private String cityOfLiving;

    public Persons() {

    }
}
