package com.example.BookApplication.Service;


import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

@Component
public class SecondProgrammatciApproach {


    TransactionTemplate transactionTemplate;

    public SecondProgrammatciApproach(TransactionTemplate transactionTemplate){
        this.transactionTemplate=transactionTemplate;
    }

    public void updateUser (){

        TransactionCallback<TransactionalStatus>dbOperationTask=(status)->{
            System.out.println("Perform Operation ");
            return status;

        };
        transactionTemplate.execute(dbOperationTask);

    }

}
