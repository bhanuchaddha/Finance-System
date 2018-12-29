package com.bhanuchaddha.bank.accounts;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Bhanu Chaddha on 29-12-2018 06:55 PM.
 */
@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountResource {
    private final AccountService service;
    private final AccountMapper mapper;

    @PostMapping
    public AccountDTO createAccount (@RequestBody Account account) {
        return mapper.toAccountDto(service.save(account));
    }

    @GetMapping("/{id}")
    public AccountDTO getAccount (@PathVariable("id") Long id) {
        return service.findById(id)
                .map(mapper::toAccountDto)
                .orElseThrow(()-> new RuntimeException("Not found"));
    }

    @GetMapping
    public List<AccountDTO> getAccounts(@RequestParam(value = "customerNumber", required = false) Long customerNumber ) {

        if ( customerNumber == null ) {
            return mapper.toAccountDTOs(service.findAll());
        }
        return service.findByCustomerNumber(customerNumber)
                .map(mapper::toAccountDTOs)
                .orElseThrow(()-> new RuntimeException("Not found"));
    }
}
