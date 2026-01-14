package com.snipper.springDemoApplication.Service;

import com.snipper.springDemoApplication.DTO.Employeedto;
import com.snipper.springDemoApplication.Entity.EmployeeEntity;
import com.snipper.springDemoApplication.Respositry.EmployeeRepo;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements InitializingBean, DisposableBean {




    Employeedto empdto;

//    Setter injection
//    @Autowired
//    public void setEmpdto(Employeedto empdto){
//        this.empdto=empdto;
//        System.out.println("Setter Injection is Running");
//    }

//    Construction injection

    @Autowired
    EmployeeService(Employeedto employeedto){
        this.empdto=employeedto;
        System.out.println("Construciton Injection");
    }

//This method is run when we want to perform the some taks after the creation of the beans
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
    }

//    This destroy method will run only when the application will be stop

//    we can also do this with the help of annotaiton where we do not need to implements the interface jsut make a method and use annotation liek postconstruct , and PreDestroy etc
    @Override
    public void destroy() throws Exception {

        System.out.println("Destroy Bean");
    }



    @Autowired
    EmployeeRepo emprep ;
    public Employeedto getEmployee(String id){
      EmployeeEntity employee =  emprep.getEmployee(id);
 Employeedto empdtoo=empdto.EmployeeMapper(employee);
 return empdtoo;
    }


}
