package org.kj6682.kosimo.dm;

import java.math.BigDecimal;

/**
 * Created by luigi on 23.04.16.
 */
enum FakeAccount{
    UNKNOWN;
    Account asAccount() {
        Account a = new Account();
        a.setId(Long.MIN_VALUE);
        a.setOwner("unknown");
        a.setType("unknown");
        a.setBalance(BigDecimal.ZERO);
        return a;
    };
}
