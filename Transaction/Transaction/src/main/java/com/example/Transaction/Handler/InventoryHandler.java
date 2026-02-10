package com.example.Transaction.Handler;

import com.example.Transaction.Entity.Product;
import com.example.Transaction.Repository.InventoryRepo;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
public class InventoryHandler {

    private final InventoryRepo inventoryRepo;


//    Injection
    public InventoryHandler(InventoryRepo inventoryRepo){
        this.inventoryRepo=inventoryRepo;
    }

//    update Hanlder

    @Transactional(propagation = Propagation.REQUIRED)
    public Product  updateProductDetails(Product product){


//        Important Notes : if order is place then after that  we need to update in the Product (inventory) but due to some reason we get error and do not update in the invntory then it is dataincoin
//       we can overcome this issues or problem with the help of Transaction
//
//        throw exception here so that it will place an order but do not Update in the product table
        if(product.getPrice() > 25000){
            throw new RuntimeException("DB crashed");
        }

        return inventoryRepo.save(product);

    }

//    get product






    public Product getProduct(int id){
        return inventoryRepo.findById(id).orElseThrow(()->new RuntimeException("Product not Found "));
    }



}
