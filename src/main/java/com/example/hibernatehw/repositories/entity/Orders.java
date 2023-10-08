package com.example.hibernatehw.repositories.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Builder
@AllArgsConstructor
@Table( name = "Orders")
public class Orders {
    @Id
    @GeneratedValue
    int id;
    Date date;

    @ManyToOne
    @JoinColumn(name = "customers_id",
            nullable=false)
    Customers customers;

    String product_name;
    int amount;

    public Orders() {

    }
}
