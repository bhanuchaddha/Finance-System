package com.bhanuchaddha.bank.accounts;

import org.mapstruct.Mapper;

import java.util.List;

/**
 * Created by Bhanu Chaddha on 29-12-2018 08:26 PM.
 */
@Mapper(componentModel="spring")
public interface AccountMapper {
    Account toAccount(AccountDTO accountDTO);
    AccountDTO toAccountDto(Account account);
    List<Account> toAccounts( List<AccountDTO> accountDTOs );
    List<AccountDTO> toAccountDTOs( List<Account> accounts);
}
