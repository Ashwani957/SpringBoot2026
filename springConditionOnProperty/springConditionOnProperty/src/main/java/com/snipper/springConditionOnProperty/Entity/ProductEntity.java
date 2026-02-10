package com.snipper.springConditionOnProperty.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.stereotype.Controller;

@Entity
public class ProductEntity {
    private String ProductName;
    private String Price;
    @Id
    private String id;
}
