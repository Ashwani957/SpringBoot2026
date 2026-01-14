package com.snipper.springDemoApplication.Respositry;

import com.snipper.springDemoApplication.Entity.EmployeeEntity;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepo {


    public EmployeeEntity getEmployee(String id ){

//        it directly link to ddatabase
        return new EmployeeEntity("1","Ashwani","ComputerScience",22);
    }



}
