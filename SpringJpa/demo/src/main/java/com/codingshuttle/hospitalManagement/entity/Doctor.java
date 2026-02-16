package com.codingshuttle.hospitalManagement.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @Column(nullable = false,length=100)
    private String name;
    @Column(length=100)
    private String speclization ;

    @Column(nullable = false,unique = true,length=100)
    private String email ;

    @ManyToMany(mappedBy="doctors")
    private Set<Department> department=new HashSet<>();

}
