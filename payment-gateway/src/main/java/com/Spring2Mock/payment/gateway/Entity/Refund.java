package com.Spring2Mock.payment.gateway.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Refund {

    private int amount;

    @OneToOne
    @JoinColumn
    Transaction transaction;

    @ManyToOne
    @JoinColumn
    User user;
}
