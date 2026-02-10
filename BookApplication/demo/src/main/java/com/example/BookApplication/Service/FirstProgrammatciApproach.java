package com.example.BookApplication.Service;

import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;


@Component
public class FirstProgrammatciApproach {

    PlatformTransactionManager transactionmanager;

    public FirstProgrammatciApproach(PlatformTransactionManager transactionManager){
        this.transactionmanager=transactionManager;
    }

    public void updateUser(){
        TransactionStatus status=transactionmanager.getTransaction(null);

        try{
            System.out.println("Do Operation");
            transactionmanager.commit(status);
        }
        catch(Exception e){
            transactionmanager.rollback(status);

        }
    }
}
