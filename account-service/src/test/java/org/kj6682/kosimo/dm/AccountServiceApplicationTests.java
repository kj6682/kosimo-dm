package org.kj6682.kosimo.dm;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.HttpEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.math.BigDecimal;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Main.class)
@WebAppConfiguration
public class AccountServiceApplicationTests {

    Account debit;
    Account credit;

    @Autowired
    AccountRepository accountRepo;


    @Autowired
    AccountController accountCtrl;

    @Before
    public void init() {
        debit = new Account();
        credit = new Account();

        debit.setBalance(BigDecimal.valueOf(100L));
        credit.setBalance(BigDecimal.ZERO);

        accountRepo.save(debit);
        accountRepo.save(credit);
    }

    @Ignore
    @Test
    public void goodTransfer() {

        assertNotNull(debit);
        assertNotNull(credit);
        assertEquals(100L, debit.getBalance().longValue());
        assertEquals(0L, credit.getBalance().longValue());

        HttpEntity result = accountCtrl.transfer(String.valueOf(debit.getId()),
                String.valueOf(credit.getId()),
                BigDecimal.valueOf(100L),
                "EUR");

        debit = accountRepo.findOne(debit.getId());
        credit = accountRepo.findOne(credit.getId());
        assertEquals(0L, debit.getBalance().longValue());
        assertEquals(100L, credit.getBalance().longValue());

    }

}
