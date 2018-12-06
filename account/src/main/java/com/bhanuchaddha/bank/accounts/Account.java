package com.bhanuchaddha.bank.accounts;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * Created by ben on 06-12-2018 03:52 PM.
 */
@Getter
@NoArgsConstructor
@Entity
public class Account {
    @Id
    @GeneratedValue
    private long number;
    private long customerNumber;
    private BigDecimal amount;

    public Account(BigDecimal amount) {
        this.amount = amount;
    }
}
