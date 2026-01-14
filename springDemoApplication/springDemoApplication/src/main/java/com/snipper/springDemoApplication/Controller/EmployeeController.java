package com.snipper.springDemoApplication.Controller;

import com.snipper.springDemoApplication.DTO.Employeedto;
import com.snipper.springDemoApplication.Entity.EmployeeEntity;
import com.snipper.springDemoApplication.Entity.ScopeBean;
import com.snipper.springDemoApplication.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {

@Autowired
ScopeBean scoper ;

    @Autowired
    EmployeeService employeeService;

    EmployeeController(EmployeeService employeeService){
        this.employeeService=employeeService;
    }
    @GetMapping("/getEmployee/{id}")
    public ResponseEntity<Employeedto> getEmployee(@PathVariable  String id ){
  Employeedto empdto=  employeeService.getEmployee(id);
 return ResponseEntity.ok(empdto);

    } ;


//    crud operation
    // Add
    @RequestMapping(path="/addEmployee", method = RequestMethod.POST)
    public String addEmployee(EmployeeEntity empEntity){
        return " add";
    }
//    Update
    @RequestMapping(path="/updateEmployee", method = RequestMethod.POST)
    public String updateEmployee(EmployeeEntity empEntity){
        return " add";
    }

    // Delete
    @RequestMapping(path="/deleteEmployee" , method=RequestMethod.DELETE)
    public String deleteEmployee(EmployeeEntity employeeEntity){
        return "Delete";
    }

//
}
