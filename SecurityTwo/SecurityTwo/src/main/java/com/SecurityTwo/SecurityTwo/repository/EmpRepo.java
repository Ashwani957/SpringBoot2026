package com.SecurityTwo.SecurityTwo.repository;

import com.SecurityTwo.SecurityTwo.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpRepo  extends JpaRepository<Employee,Integer> {

    public Employee findByEmail(String email);

}
