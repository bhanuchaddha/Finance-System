package com.bhanuchaddha.bank.accounts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by ben on 06-12-2018 09:09 PM.
 */
@RepositoryRestResource(path = "accounts")
public interface AccountRepository extends JpaRepository<Account, Long> {
}
