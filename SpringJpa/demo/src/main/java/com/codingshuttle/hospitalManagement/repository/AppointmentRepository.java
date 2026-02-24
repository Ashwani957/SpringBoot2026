package com.codingshuttle.hospitalManagement.repository;

import com.codingshuttle.hospitalManagement.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}