package com.snipper.springConditionOnProperty.Controller;

import com.snipper.springConditionOnProperty.Entity.ExceptionHandling;
import com.snipper.springConditionOnProperty.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Product {


    @Autowired
    ProductService productService;
    @GetMapping("/getProductById/{productId}")
    public ResponseEntity<?> getProductByid (@PathVariable("productId") int id ){

        System.out.println("getProudctById is CAlling with id"+id);
    String p= productService.getproductByid(id);

    if(p.equals("not found")){
        return ResponseEntity.ok(new ExceptionHandling("Product of particular id will not found"+id));

    }
    return  ResponseEntity.ok(p);

    }



//Second way to handle exception using the ExceptionHandler

//this exception ahndler will handler all the  component excetpiton in this product file
//    @ExceptionHandler(ExceptionHandling.class)
//    public ResponseEntity<?> handleProductNotFoundException(ExceptionHandling exception){
//        return ResponseEntity.ok(new ExceptionHandling("Product of particular id will not found"));
//    }

}
