package com.example.Transaction.Handler;


 import com.example.Transaction.Repository.AuditLogRepo;
import com.example.Transaction.Entity.Order;
import com.example.Transaction.Entity.AuditLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
 import org.springframework.web.servlet.handler.AbstractDetectingUrlHandlerMapping;

 import java.time.LocalDateTime;

@Component
public class    AuditLogHandler {


    private final AuditLogRepo auditLogRepo;


    @Autowired
  AuditLogHandler(AuditLogRepo auditLogRepo){
    this.auditLogRepo=auditLogRepo;
  }



//    Log audit details (runs in independent transaction)
//  Required_new  are used when we want to complete execute the function even the  main trnasaction will be fail


    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void logAuditDetails(Order order, String action ){


     AuditLog auditLog1=new AuditLog();
//        auditLog1.setOrder(Long.valueOf(order.getId()));
      auditLog1.setOrderId(Long.valueOf(order.getId()));
        auditLog1.setAction(action);
        auditLog1.setTimestamp(LocalDateTime.now());
//        Save the audit log
        auditLogRepo.save(auditLog1);



    }

}
