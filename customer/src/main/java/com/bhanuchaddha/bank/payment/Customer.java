package com.bhanuchaddha.bank.payment;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

/**
 * Created by ben on 06-12-2018 09:47 PM.
 */
@Entity
@Getter
@NoArgsConstructor
public class Customer {
    private long id;
    private String name;
    private String address;
}
