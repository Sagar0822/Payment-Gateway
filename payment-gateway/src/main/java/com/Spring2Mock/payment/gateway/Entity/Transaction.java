package com.Spring2Mock.payment.gateway.Entity;

import com.Spring2Mock.payment.gateway.Enum.TransactionStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transactionId;

    private int amount;

    private int amountDeducted;

    private TransactionStatus status;

    @CreationTimestamp
    private int time;

    @ManyToOne
    @JoinColumn
    User user;

    @OneToOne(mappedBy = "transaction", cascade = CascadeType.ALL)
    Refund refund;
}
