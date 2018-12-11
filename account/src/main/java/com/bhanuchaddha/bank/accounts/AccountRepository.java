package com.bhanuchaddha.bank.accounts;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import java.util.List;

/**
 * Created by ben on 06-12-2018 09:09 PM.
 */
@RepositoryRestController
public interface AccountRepository extends CrudRepository<Account, Long> {

    List<Account> findByCustomerNumber(@Param("customerNumber") long customerNumber);
}
