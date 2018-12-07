package com.bhanuchaddha.bank.accounts;

import lombok.Getter;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by ben on 06-12-2018 09:05 PM.
 */
@Getter
public class Payment {

    private long id;
    private long fromAccount;
    private long toAccount;
    private BigDecimal amount;
    private Date date;
}
