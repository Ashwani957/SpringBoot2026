package com.example.Transaction.Repository;


import com.example.Transaction.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepo extends JpaRepository<Product,Integer> {
}
