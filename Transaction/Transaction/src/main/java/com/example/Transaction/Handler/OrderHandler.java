package com.example.Transaction.Handler;

import com.example.Transaction.Entity.Order;
import com.example.Transaction.Repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderHandler {
    private final OrderRepo orderRepo;


    @Autowired
    public OrderHandler(OrderRepo orderRepo1){
        this.orderRepo=orderRepo1;
    }



//    for example Second
    @Transactional(propagation= Propagation.REQUIRED)
    public Order saveOrder(Order order){
        return orderRepo.save(order);
    }
}
