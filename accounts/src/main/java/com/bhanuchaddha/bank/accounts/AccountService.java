package com.bhanuchaddha.bank.accounts;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by Bhanu Chaddha on 28-12-2018 11:22 PM.
 */
@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository repository;

    public List<Account> findAll() {
        return repository.findAll();
    }

    public List<Account> findAll(Sort sort) {
        return repository.findAll(sort);
    }

    public List<Account> findAllById(Iterable<Long> iterable) {
        return repository.findAllById(iterable);
    }

    public List<Account> saveAll(Iterable<Account> iterable) {
        return repository.saveAll(iterable);
    }

    public void flush() {
        repository.flush();
    }

    public Account saveAndFlush(Account s) {
        return repository.saveAndFlush(s);
    }

    public void deleteInBatch(Iterable<Account> iterable) {
        repository.deleteInBatch(iterable);
    }

    public void deleteAllInBatch() {
        repository.deleteAllInBatch();
    }

    public Account save(Account s) {
        return repository.save(s);
    }

    public Account getOne(Long aLong) {
        return repository.getOne(aLong);
    }

    public Optional<Account> findById(Long aLong) {
        return repository.findById(aLong);
    }

    public Optional<List<Account>> findByCustomerNumber(@Param("customerNumber") long customerNumber) {
        return repository.findByCustomerNumber(customerNumber);
    }
}
