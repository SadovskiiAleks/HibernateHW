package com.example.hibernatehw.repositories.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Entity
@Data
@Builder
@AllArgsConstructor
@Table(name = "Customers")
public class Customers {
    @Id
    @GeneratedValue
    int id;

    String name;
    String surname;
    int age;
    @Column(name = "phone_number")
    long phoneNumber;

    @OneToMany(mappedBy = "customers")
    private Set<Orders> ordersSet;

    public Customers() {

    }
}
