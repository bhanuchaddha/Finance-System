package com.bhanuchaddha.bank.payment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by ben on 06-12-2018 09:50 PM.
 */
@RepositoryRestResource
public interface PaymentRepository extends JpaRepository<Payment,Long> {
}
