package com.bhanuchaddha.bank.payment;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by ben on 12-12-2018 11:24 PM.
 */
@RestController
@RequestMapping("/customers")
@Slf4j
@RequiredArgsConstructor
public class CustomerResource {

    private final CustomerRepository repository;
    private final RestTemplateBuilder restTemplateBuilder;
    private final CustomerProperties customerProperties;
    private final DiscoveryClient discoveryClient;

    @GetMapping("/{id}")
    public Customer findCustomer(@PathVariable("id") Long id) {
        return repository.findById(id)
                .orElseThrow(()->  new RuntimeException("Customer not found"));
    }

    @GetMapping
    public List<Customer> getAllCustomers(){
        return repository.findAll();
    }

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        log.info("max-account",customerProperties.getMaximumAccountsPerCustomer());
        Customer newCustomer= repository.save(customer);
        RestTemplate restTemplate = restTemplateBuilder.build();
        restTemplate.postForEntity(
                discoveryClient.getInstances("account").get(0).getUri().toString()+"/accounts"
                , new Account(newCustomer.getId(), customerProperties.getInitAccountBalance())
                , Account.class);
        return newCustomer;
    }
}
