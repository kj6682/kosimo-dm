package org.kj6682.kosimo.dm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by luigi on 23.04.16.
 */
@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    ErrorHandler errorHandler;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Account find(@PathVariable("id") String id) {
        return this.accountRepository.findById(Long.decode(id).longValue())
                .orElseGet(()-> FakeAccount.UNKNOWN.asAccount());
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Account> findAll() {
        List<Account> result = new LinkedList<Account>();
        accountRepository.findAll().forEach(item -> result.add(item));
        return result;
    }


    @RequestMapping(value = "/findByOwner/{owner}", method = RequestMethod.GET)
    public List<Account> findByOwner(@PathVariable("owner") String owner) {
        return accountRepository.findByOwner(owner);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Long create(@RequestParam(value = "owner") String owner,
                       @RequestParam(value = "amount") String amount,
                       @RequestParam(value = "type") String type) {
        Account larva = new Account();
        larva.setOwner(owner);
        larva.setBalance(new BigDecimal(amount));
        larva.setType(type);
        Account butterfly = accountRepository.save(larva);
        return butterfly.getId();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public HttpEntity<String> delete(@PathVariable("id") String id) {
        validateAccount(id);
        accountRepository.delete(Long.decode(id).longValue());
        return new ResponseEntity<>(String.format("Account (%s) has been removed", id), HttpStatus.OK);
    }

    void validateAccount(String id) {
        this.accountRepository.findById(Long.decode(id).longValue())
                .orElseThrow(() -> new AccountNotFoundException(id));
    }

}//:)

