package com.codingshuttle.hospitalManagement.repository;

import com.codingshuttle.hospitalManagement.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}