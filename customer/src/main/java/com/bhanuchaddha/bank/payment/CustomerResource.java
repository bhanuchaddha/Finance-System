package com.bhanuchaddha.bank.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

/**
 * Created by ben on 12-12-2018 11:24 PM.
 */
@RestController
@RequestMapping("/customer")
public class CustomerResource {

    @Autowired
    CustomerRepository repository;

    @Autowired
    RestTemplateBuilder restTemplateBuilder;

    @Value("${account.service.base.url}")
    private String accountsUrl;

    @GetMapping("/{id}")
    public Customer findCustomer(@PathVariable("id") long id) {
        return repository.findById(id)
                .orElseThrow(()->  new RuntimeException("Customer not found"));
    }

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        Customer newCustomer= repository.save(customer);
        RestTemplate restTemplate = restTemplateBuilder.build();
        restTemplate.postForEntity(
                accountsUrl
                ,new Account(newCustomer.getId(), BigDecimal.valueOf(1000l))
                , Account.class);
        return newCustomer;
    }
}
