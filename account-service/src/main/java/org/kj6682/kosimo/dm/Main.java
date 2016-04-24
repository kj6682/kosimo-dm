package org.kj6682.kosimo.dm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.util.Arrays;



@SpringBootApplication
public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    public CommandLineRunner demo(AccountRepository repository) {
        return (evt) -> {
            repository.save(new Account("Kevin", "Yellow", BigDecimal.valueOf(10)));
            repository.save(new Account("Stuart", "Red", BigDecimal.valueOf(20)));
            repository.save(new Account("Bob", "Green", BigDecimal.valueOf(30)));
        };
    }

    /**
     * Created by luigi on 23.04.16.
     */
    static class AccountNotFoundException extends RuntimeException {
        AccountNotFoundException(String id) {
            super("could not find account '" + id + "'.");
        }

    }//:)

}

