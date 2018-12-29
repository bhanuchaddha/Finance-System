package com.bhanuchaddha.bank.accounts;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * Created by Bhanu Chaddha on 29-12-2018 07:48 PM.
 */
@Getter
@Setter
@NoArgsConstructor // required to use mapstruct
public class AccountDTO {
    private Long number;
    @NonNull
    private Long customerNumber;
    @NonNull
    private BigDecimal amount;
}
