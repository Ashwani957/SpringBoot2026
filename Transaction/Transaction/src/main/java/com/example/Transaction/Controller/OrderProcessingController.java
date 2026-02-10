package com.example.Transaction.Controller;
import com.example.Transaction.Entity.Order;
import com.example.Transaction.Service.OrderProcessingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderProcessingController {

    private final OrderProcessingService orderProcessingService;

    public OrderProcessingController(OrderProcessingService orderProcessingService){
        this.orderProcessingService=orderProcessingService;
    }


//    endponints to update inventory

    @PostMapping
    public ResponseEntity<?> placeOrder(@RequestBody Order order){
       return  ResponseEntity.ok(orderProcessingService.placeAndOrder(order));
    }




}
