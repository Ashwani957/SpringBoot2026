package com.codingshuttle.hospitalManagement.repository;

import com.codingshuttle.hospitalManagement.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}