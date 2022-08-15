package com.example.querydsl.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
public class Customer {
    @Id
    @Column(name = "id", updatable = false)
    @EqualsAndHashCode.Include
    private Long id;

    @Column
    private String name;

    public Customer(String name) {
        this.name = name;
    }

    public Customer(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Customer() {

    }
}
