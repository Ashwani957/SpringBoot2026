package com.codingshuttle.hospitalManagement.repository;

import com.codingshuttle.hospitalManagement.entity.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceRepository extends JpaRepository<Insurance, Long> {
}