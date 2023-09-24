package com.acme.test01.mikheiligordeziani.model;

import com.acme.test01.mikheiligordeziani.exception.AccountCannotBeCreatedException;
import com.acme.test01.mikheiligordeziani.exception.WithdrawalAmountTooLargeException;

public class CurrentAccount implements Account{
    private final int MAX_OVERDRAFT_LIMIT = 100_000;
    private final int DEFAULT_OVERDRAFT_LIMIT = 50_000;
    private int overdraftLimit;
    private int balance;

    public CurrentAccount(int overdraft) {
        if(overdraft > MAX_OVERDRAFT_LIMIT) throw new AccountCannotBeCreatedException("Maximum limit for overdraft is R" + MAX_OVERDRAFT_LIMIT);
        this.overdraftLimit = overdraft;
    }

    public CurrentAccount() {
        this.overdraftLimit = DEFAULT_OVERDRAFT_LIMIT;
    }

    @Override
    public int withdraw(int amount) throws WithdrawalAmountTooLargeException {
        if(amount > balance + overdraftLimit) throw new WithdrawalAmountTooLargeException("Balance not enough");
        balance -= amount;
        return balance;
    }

    @Override
    public int deposit(int amount) {
        balance += amount;
        return balance;
    }
}
