package net.elgali.bank.service;

import net.elgali.bank.model.Account;

import java.math.BigDecimal;

/**
 * Created by aelgali on 9/6/14.
 */
public interface AccountService {
    void transferBalance(Account from, Account to, BigDecimal amount);
}
