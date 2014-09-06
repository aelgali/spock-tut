package net.elgali.bank.service;

import net.elgali.bank.model.Account;

import java.math.BigDecimal;

/**
 * Created by aelgali on 9/6/14.
 */
public class AccountServiceImpl implements AccountService {
    @Override
    public void transferBalance(Account from, Account to, BigDecimal amount) {
        from.setBalance(from.getBalance().subtract(amount));
        to.setBalance(to.getBalance().add(amount));
    }
}
