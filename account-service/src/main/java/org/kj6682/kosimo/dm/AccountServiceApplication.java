package org.kj6682.kosimo.dm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
public class AccountServiceApplication {

	private static final Logger log = LoggerFactory.getLogger(AccountServiceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AccountServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(AccountRepository repository) {
		return (args) -> {
			// save a couple of customers
			Account account = new Account();
			account.setOwner("John");
			account.setBalance(BigDecimal.ZERO);
			account.setType("Red");

			repository.save(account);

			account = new Account();
			account.setOwner("Paul");
			account.setBalance(BigDecimal.ONE);
			account.setType("Green");

			repository.save(account);

			account = new Account();
			account.setOwner("George");
			account.setBalance(BigDecimal.TEN);
			account.setType("Green");

			repository.save(account);

			account = new Account();
			account.setOwner("Ringo");
			account.setBalance(BigDecimal.valueOf(100L));
			account.setType("Yellow");

			repository.save(account);

			// fetch all customers
			log.info("Accounts found with findAll():");
			log.info("-------------------------------");
			for (Account account1 : repository.findAll()) {
				log.info(account1.toString());
			}
			log.info("");
		};
	}

}

