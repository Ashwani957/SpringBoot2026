package com.snipper.springDemoApplication.DTO;

import com.snipper.springDemoApplication.Entity.EmployeeEntity;
import org.springframework.stereotype.Component;

@Component
public class Employeedto {
    String name ;
    String dept;
    Integer age ;

    public void setName(String name) {
        this.name = name;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getDept() {
        return dept;
    }

    public Integer getAge() {
        return age;
    }

//    Row Mapper

    public Employeedto EmployeeMapper(EmployeeEntity employee){
        this.setName(employee.getName());
        this.setAge(employee.getAge());
        this.setDept(employee.getDept());
        return this;
    };
}
