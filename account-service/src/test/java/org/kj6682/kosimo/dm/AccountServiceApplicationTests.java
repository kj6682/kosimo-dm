package org.kj6682.kosimo.dm;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.HttpEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AccountServiceApplication.class)
public class AccountServiceApplicationTests {

    Account debit;
    Account credit;

    @Autowired
    AccountRepository accountRepo;

    @Autowired
    Transfer transfer;

    @Before
    public void init() {
        debit = new Account();
        credit = new Account();

        debit.setBalance(BigDecimal.valueOf(100L));
        credit.setBalance(BigDecimal.ZERO);

        accountRepo.save(debit);
        accountRepo.save(credit);
    }


    @Test
    public void contextLoads() {

        assertNotNull(debit);
        assertNotNull(credit);
        assertEquals(100L, debit.getBalance().longValue());
        assertEquals(0L, credit.getBalance().longValue());

        HttpEntity result = transfer.execute(String.valueOf(debit.getId()),
                String.valueOf(credit.getId()),
                BigDecimal.valueOf(100L),
                "EUR");
        assertEquals("Amount for account 5 is now 0", result.getBody());
        assertEquals("Amount for account 5 is now 0", result.getBody());

        debit = accountRepo.findOne(debit.getId());
        credit = accountRepo.findOne(credit.getId());
        assertEquals(0L, debit.getBalance().longValue());
        assertEquals(100L, credit.getBalance().longValue());

    }

}
