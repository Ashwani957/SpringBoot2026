package com.example.Transaction.Service;

import com.example.Transaction.Entity.Order;
import com.example.Transaction.Entity.Product;
import com.example.Transaction.Handler.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderProcessingService {

    private final OrderHandler orderHandler ;
    private final InventoryHandler inventoryHandler;
    private final AuditLogHandler auditLogHandler;
    private final PaymentValidationHandler paymentValidationHandler;
    private final NotificationHandler notificationHandler;


    @Autowired
    public OrderProcessingService(OrderHandler orderHanlder,InventoryHandler inventoryHandler,AuditLogHandler auditLogHandler,PaymentValidationHandler paymentValidationHandler,NotificationHandler notificationHandler){
        this.orderHandler=orderHanlder;
        this.inventoryHandler= inventoryHandler;
        this.auditLogHandler=auditLogHandler;
        this.paymentValidationHandler=paymentValidationHandler;
        this.notificationHandler=notificationHandler;

    }

//    login to place the order


//    To overcome the issue of the data incoinsitneyc we should use the transacitonla annotation here

//    Propagation mean how transaction can communicate each other
//    isloation means it see the chnages made by another transaction
//    @Transactional(readOnly = false , propagation = Propagation.REQUIRED , isolation = Isolation.READ_COMMITTED)
//        public Order placeAndOrder(Order order){
////        get Product Inventory;
//           Product product = inventoryHandler.getProduct(order.getProductId());
////            Validate stock availibitly
//          if(order.getQuantity()> product.getStockQuantity()){
//              throw new RuntimeException("Insufficient stock are avaialble ");
//          }
//
//            // upate total price  in order entity
//       order.setTotalPrice(order.getQuantity() * product.getPrice());
////            save order
//          Order saveOrder= orderHandler.saveOrder(order);
////            update stock in inventory
//            int availableStock=product.getStockQuantity()-order.getQuantity();
//            product.setStockQuantity(availableStock);
//            inventoryHandler.updateProductDetails(product);
//            return saveOrder;
//
//
//
//        }



//    Example two start propgation
//first level of Propagation
/*
1.Required:it will check if there is any existing transaction then i will use it otherwise create a  new transaction
2.Required_new : it will always create the new transaction , suspending the existing transaction if happening
3.Mondatroy : if we mark any method as transactional mandatory then we need to call it only inside the another transaction . if we do not call it inside the another trnasaction then it will thrown an error
4.NEVER: Never means the method  must not run inside the transactions if transaction already exists spring throws an exception
5.NOT_SUPPORTED : Executed  method without transaction , suspending any active transaction if any present understand
6.Support : support means if any transaction will be active then join it otherwise run without transaction
7.NESTED : Executes with in the transaction  allowing the nested transaction to roll back  independently without affecting the outer transaction
JPA dialect does not support the nested transaction
 */
@Transactional(readOnly = false , propagation = Propagation.REQUIRED , isolation = Isolation.READ_COMMITTED)
public Order placeAndOrder(Order order){
//        get Product Inventory;
    Product product = inventoryHandler.getProduct(order.getProductId());
//            Validate stock availibitly
    if(order.getQuantity()> product.getStockQuantity()){
        throw new RuntimeException("Insufficient stock are avaialble ");
    }

    // upate total price  in order entity
    order.setTotalPrice(order.getQuantity() * product.getPrice());
//            save order
//    Here we call the another method saveOrder that having a transactional
    Order saveOrder=null ;
    try {
       orderHandler.saveOrder(order);
//            update stock in inventory
        int availableStock = product.getStockQuantity() - order.getQuantity();
        product.setStockQuantity(availableStock);
        inventoryHandler.updateProductDetails(product);

//    required_new : are used when a method must execute its own independent trasactions so its commit and rollback is not afftercted by the caller transaction

        auditLogHandler.logAuditDetails(order,"order Placement success");
    }
    catch(Exception ex){
        auditLogHandler.logAuditDetails(order,"order placement failed");
    }

//    notificaiton Handler : we need to call this method outside the transaction understand
//    notificationHandler.sendOrderConfirmationNotification(order);


 // SendOrderConfirmation;

    if(order.getTotalPrice()>1000){
        throw new RuntimeException("Error  in payment validation ");
    }
    paymentValidationHandler.validatePayment(order);
//    calling the transaction getCustomerDetails()
    getCustomerDetails();
    return saveOrder;
    }

// getCustomerDetails

    @Transactional(propagation = Propagation.SUPPORTS)
    public void getCustomerDetails(){
    System.out.println("Customer Details are fetched !!!");
    }




//    Call this method after  placeAnOrder  is successfully completed

    public void processOrder(Order order){
//    step1: Place and order
        Order savedorder=placeAndOrder(order);

//        step2:Send notification (non-transaction)
        notificationHandler.sendOrderConfirmationNotification(order);
    }







}
