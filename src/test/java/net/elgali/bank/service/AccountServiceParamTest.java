package net.elgali.bank.service;

import net.elgali.bank.model.Account;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by aelgali on 9/7/14.
 */

@RunWith(Parameterized.class)
public class AccountServiceParamTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new BigDecimal(100.00), new BigDecimal(150.00), new BigDecimal(50.00)}
        });
    }

    private AccountService accountService;
    private Account accountA;
    private Account accountB;

    private BigDecimal accountABalance;
    private BigDecimal accountBBalance;
    private BigDecimal amount;

    public AccountServiceParamTest(BigDecimal accountABalance, BigDecimal accountBBalance, BigDecimal amount) {
        this.accountABalance = accountABalance;
        this.accountBBalance = accountBBalance;
        this.amount = amount;

    }

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
    public void transferMoney() {
        accountA.setBalance(accountABalance);
        accountB.setBalance(accountBBalance);
        accountService.transferBalance(accountA, accountB, amount);

    }

}
