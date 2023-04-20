package com.Spring2Mock.payment.gateway.Repository;

import com.Spring2Mock.payment.gateway.Entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
}
