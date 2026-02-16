package com.codingshuttle.hospitalManagement.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime appointmentTime;


    @Column(length=500)
    private String reason ;

//    always read like many appointment will be taken by one patient but in one appointment only one paitnet will be checked
    @ManyToOne
    @JoinColumn(name="patient_id" , nullable = false)
    private Patient patient;


    @ManyToOne
    @JoinColumn(nullable = false)
    private Doctor doctor;



}
