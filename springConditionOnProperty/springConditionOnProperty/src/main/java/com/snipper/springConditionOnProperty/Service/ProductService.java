package com.snipper.springConditionOnProperty.Service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class ProductService {


    public String  getproductByid( int id ){
        if(id==1){
            return "First Product is avaliable  s";
        }
        else if (id==2){
            return "Second product is availabe";
        }
        return "not found";
    }

}
