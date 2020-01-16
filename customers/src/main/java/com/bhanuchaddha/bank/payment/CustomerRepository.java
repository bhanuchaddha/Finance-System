package com.bhanuchaddha.bank.payment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by ben on 06-12-2018 09:50 PM.
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
