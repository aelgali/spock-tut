package net.elgali.bank.service;

import net.elgali.bank.model.Account;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

/**
 * Created by aelgali on 9/6/14.
 */
public class AccountServiceTest {

    AccountService accountService;
    Account accountA;
    Account accountB;

    @Before
    public void setUp() {
        accountService = new AccountServiceImpl();

        accountA = new Account();
        accountA.setId(1L);
        accountA.setOwnerName("Owner A");
        accountA.setNumber("ABC111111111");

        accountB = new Account();
        accountB.setId(2L);
        accountB.setOwnerName("Owner B");
        accountB.setNumber("ABC222222222");
    }

    @Test
    public void transferBalance() {
        accountA.setBalance(new BigDecimal(100.00));
        accountB.setBalance(new BigDecimal(150.00));

        accountService.transferBalance(accountA, accountB, new BigDecimal(50));

        assertEquals(new BigDecimal(50), accountA.getBalance());
        assertEquals(new BigDecimal(200), accountB.getBalance());
    }


}
