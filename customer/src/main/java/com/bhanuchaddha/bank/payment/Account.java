package com.bhanuchaddha.bank.payment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * Created by ben on 06-12-2018 03:52 PM.
 */
@Getter
@Setter
@NoArgsConstructor
public class Account {
    private long number;
    private long customerNumber;
    private BigDecimal amount;

    public Account(BigDecimal amount) {
        this.amount = amount;
    }

    public Account(long customerNumber, BigDecimal amount) {
        this.customerNumber = customerNumber;
        this.amount = amount;
    }
}
