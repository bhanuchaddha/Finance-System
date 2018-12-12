package com.bhanuchaddha.bank.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by ben on 12-12-2018 11:24 PM.
 */
@RestController
@RequestMapping("/customer")
public class CustomerResource {

    @Autowired
    CustomerRepository repository;

    @GetMapping("/{id}")
    public Customer findCustomer(@PathVariable("id") long id) {
        return repository.findById(id)
                .orElseThrow(()->  new RuntimeException("Customer not found"));
    }

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
       return repository.save(customer);
    }
}
