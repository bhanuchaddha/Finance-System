package com.bhanuchaddha.bank.payment;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

/**
 * Created by Bhanu Chaddha on 29-12-2018 11:47 PM.
 */
@Getter
@Setter
@Configuration // required for injeciton
@ConfigurationProperties(prefix = "customers")
public class CustomerProperties {

    private String accountsUrl;
    private BigDecimal initAccountBalance;
    private int maximumAccountsPerCustomer;
}
