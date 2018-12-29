package com.bhanuchaddha.bank.accounts;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * Created by ben on 06-12-2018 03:52 PM.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue
    private Long number;
    private Long customerNumber;
    private BigDecimal amount;

    public Account(BigDecimal amount) {
        this.amount = amount;
    }

}
