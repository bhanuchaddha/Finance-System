package com.bhanuchaddha.bank.payment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by ben on 06-12-2018 09:05 PM.
 */
@Getter
@NoArgsConstructor
@Entity
public class Payment {

    @Id
    @GeneratedValue
    private long id;
    private long fromAccount;
    private long toAccount;
    private BigDecimal amount;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
}
