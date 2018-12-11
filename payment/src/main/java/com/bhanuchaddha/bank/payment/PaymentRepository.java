package com.bhanuchaddha.bank.payment;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by ben on 06-12-2018 09:50 PM.
 */
@RepositoryRestResource
public interface PaymentRepository extends CrudRepository<Payment,Long> {

    @Query("select p from Payment p where p.fromAccount = ?1 or p.toAccount = ?1")
    List<Payment> getPaymentsForAccount(@Param("accountNumber") long accountNumber);
}
