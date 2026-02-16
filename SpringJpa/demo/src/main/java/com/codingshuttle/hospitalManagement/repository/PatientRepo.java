package com.codingshuttle.hospitalManagement.repository;

import com.codingshuttle.hospitalManagement.entity.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface PatientRepo extends JpaRepository<Patient,Long> {

//    all these are the query method that fetch data from the db on the basis of our condition
    Patient findByName(String name);
     List<Patient>findByBirthDateOrEmail(LocalDate date, String email);

//     JPQL : are used to wirte our own query like group by
//    Important points:
/*
@Query is used to write your own custom database query when:

Method name queries are not enough

You need complex SQL / JPQL

You want full control over the query
important Points : In the hibernate we should use the hibernate table but in the nativequery we should use the noraml query and wirte the name of the table
 */

    @Query("select p from Patient p where p.gender=?1")
    List<Patient>findByGender(@Param("gender") String gender);

//    select if we use hte gender =?1 like this then it will cause hte sql injection
    @Query("select p from Patient p where p.birthDate >:birthDate")

    List<Patient> findByBirthDate(@Param("birthDate") LocalDate birthDate);

//    JPA query
    @Query("select p.gender ,Count(p) from Patient  p group by p.gender")
    List<Object[]> filterByGender();

//    nativeQuery true means when we manually  pass the real sql query so that it will not convert into other query
    @Query(value="select * from patient_db" , nativeQuery = true)
    List<Patient> findAllPatient();

//    Update fields

    @Transactional
    @Modifying
    @Query("UPDATE Patient p SET p.name= :name where p.id=:id")
    int updateNameWithId(@Param("name") String name, @Param("id") Long id);

//    Pagination concept
//    for pagination we need the Pageable that are come from the domain package

    @Query(value="select * from patient_db" , nativeQuery = true)
    Page<Patient> findAllPatients(Pageable page);


}

//Projection :
/*
Projection means instead of returning thw whole entity we will return only the limited fields
 */
