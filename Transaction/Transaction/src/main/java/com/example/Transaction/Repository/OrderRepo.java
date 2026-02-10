package com.example.Transaction.Repository;

import com.example.Transaction.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order,Integer> {

}
