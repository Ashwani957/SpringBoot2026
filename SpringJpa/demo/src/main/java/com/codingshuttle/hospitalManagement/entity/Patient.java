package com.codingshuttle.hospitalManagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@ToString
@Getter
@Setter
@Table(
        name="patient_db",
        uniqueConstraints = {
                @UniqueConstraint(name="unique_patient_email",columnNames = {"email"}),
                @UniqueConstraint(name="unique_patient_name_birthdate",columnNames = {"name","birthDate"})

        }

)
public class Patient {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id  ;

    private String name;


    private LocalDate birthDate;
//    @Column(unique = true,name = "patient_email") // means the fields will be unique
    private String email ;
    private String gender;
//    private String bloodGroup;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

//    Here we add the insureance to the patient



//    insurance is the join coloum that join two table insurance and patient
    @OneToOne
    @JoinColumn(name="patient_insurance_id") // if we want to provide the custom name of the insurance Id  then we should use the joinColumn
    private Insurance insurance; // owning side


//    know link patient table the appointment table

//    this fields is link with the appointmets table but internally if we did not use the mappedBy then it will create the  own fields
@OneToMany(mappedBy="patient")
    private List<Appointment> appointments;



}




//Important points ;
/*
1.@UniqueConstraints are used in jpa to enforce uniqueness at database level for one or more coloumn in the table
2.@CreatedTimeStamp are crate the time and date in the database when it it crated first
3.@Column annotaiton are used to set the name of the coloum, constraints of coloumn and  any other things

 */