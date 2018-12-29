package com.bhanuchaddha.bank.accounts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by ben on 06-12-2018 09:09 PM.
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<List<Account>> findByCustomerNumber(@Param("customerNumber") long customerNumber);
}
