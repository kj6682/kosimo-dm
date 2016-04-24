package org.kj6682.kosimo.dm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by luigi on 23.04.16.
 */
@RestController
@RequestMapping("/")
public class AccountController {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    ErrorHandler errorHandler;

    @RequestMapping(value = "/accounts/{id}", method = RequestMethod.GET)
    public Account find(@PathVariable("id") String id) {
        return accountRepository.findById(Long.decode(id).longValue())
                .orElseThrow(() -> new Main.AccountNotFoundException(id));
    }

    @RequestMapping(value = "/accounts", method = RequestMethod.GET)
    public List<Account> findAll() {
        List<Account> result = new LinkedList<Account>();
        accountRepository.findAll().forEach(item -> result.add(item));
        return result;
    }


    @RequestMapping(value = "/accounts/findByOwner/{owner}", method = RequestMethod.GET)
    public List<Account> findByOwner(@PathVariable("owner") String owner) {
        return accountRepository.findByOwner(owner);
    }

    @RequestMapping(value = "/accounts", method = RequestMethod.POST)
    public Long create(@RequestParam(value = "owner") String owner,
                       @RequestParam(value = "amount") String amount,
                       @RequestParam(value = "type") String type) {
        Account result = accountRepository.save(new Account(owner, type, new BigDecimal(amount)));
        return result.getId();
    }

    @RequestMapping(value = "/accounts/{id}", method = RequestMethod.DELETE)
    public HttpEntity<String> delete(@PathVariable("id") String id) {
        validateAccount(id);
        accountRepository.delete(Long.decode(id).longValue());
        return new ResponseEntity<>(String.format("Account (%s) has been removed", id), HttpStatus.OK);
    }

    @RequestMapping(value = "/accounts/transfer", method = RequestMethod.POST)
    public HttpEntity<String> transfer(@RequestParam(value = "debit") String debit,
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
                .orElseThrow(() -> new Main.AccountNotFoundException(id)));
    }

    /**
     * Created by luigi on 23.04.16.
     */
    @ControllerAdvice
    static class ErrorHandler {

        @ExceptionHandler(UnsupportedOperationException.class)
        void unsupportedOperation(HttpServletResponse response) throws IOException {
            response.sendError(
                    HttpStatus.SERVICE_UNAVAILABLE.value(),
                    "This feature is currently unavailable"
            );
        }

        @ExceptionHandler(Main.AccountNotFoundException.class)
        void accountNotFound(HttpServletResponse response, Exception e) throws IOException {
            response.sendError(
                    HttpStatus.NOT_FOUND.value(),
                    e.getMessage()
            );
        }

        @ExceptionHandler(Exception.class)
        void handleGenericException( HttpServletResponse response, Exception e) throws IOException {
            String msg = "There was an error processing your request: " + e.getMessage();
            response.sendError(
                    HttpStatus.BAD_REQUEST.value(),
                    msg
            );
        }
    }//:)


}//:)

