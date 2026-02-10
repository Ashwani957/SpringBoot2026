package com.example.Transaction.Repository;

import com.example.Transaction.Entity.AuditLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditLogRepo extends JpaRepository<AuditLog,Long> {

}
