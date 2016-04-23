package org.kj6682.kosimo.dm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.stream.Stream;

/**
 * Created by luigi on 23.04.16.
 */
@RestController
public class TransferController {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    ErrorHandler errorHandler;

    @RequestMapping(value = "/transfer", method = RequestMethod.POST)
    public HttpEntity<String> execute(@RequestParam(value = "debit") String debit,
                                      @RequestParam(value = "credit") String credit,
                                      @RequestParam(value = "amount") BigDecimal amount,
                                      @RequestParam(value = "currency") String currency) {

        validateAccount(debit, credit);

        Account from = accountRepository.findOne(Long.decode(debit));
        Account to = accountRepository.findOne(Long.decode(credit));
        from.setBalance(from.getBalance().subtract(amount));
        to.setBalance(to.getBalance().add(amount));

        accountRepository.save(from);
        accountRepository.save(to);

        from = accountRepository.findOne(Long.decode(debit));

        return new ResponseEntity<>(String.format("Amount for account %s is now %d", debit, from.getBalance().longValue()) , HttpStatus.OK);

    }

    void validateAccount(String... ids) {
        Stream.of(ids).forEach(id ->  this.accountRepository.findById(Long.decode(id).longValue())
                .orElseThrow(() -> new AccountNotFoundException(id)));
    }

}//:)
