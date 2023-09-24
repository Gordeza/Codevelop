package com.acme.test01.mikheiligordeziani.model;

import com.acme.test01.mikheiligordeziani.exception.AccountCannotBeCreatedException;
import com.acme.test01.mikheiligordeziani.exception.WithdrawalAmountTooLargeException;

public class CurrentAccount implements Account{
    private final int MAX_OVERDRAFT_LIMIT = 100_000;
    private final int DEFAULT_OVERDRAFT_LIMIT = 50_000;
    private int overdraftLimit;
    private int balance;

    /**
     * Constructs a new CurrentAccount with a specified overdraft limit.
     *
     * @param overdraft The overdraft limit for the current account.
     * @throws AccountCannotBeCreatedException If the provided overdraft limit exceeds the maximum allowed limit.
     */
    public CurrentAccount(int overdraft) {
        if(overdraft > MAX_OVERDRAFT_LIMIT) throw new AccountCannotBeCreatedException("Maximum limit for overdraft is R" + MAX_OVERDRAFT_LIMIT);
        this.overdraftLimit = overdraft;
    }

    public CurrentAccount() {
        this.overdraftLimit = DEFAULT_OVERDRAFT_LIMIT;
    }

    /**
     * Withdraws a specified amount from the current account's balance, considering the overdraft limit.
     *
     * @param amount The amount to be withdrawn from the account.
     * @return The updated balance after the withdrawal.
     * @throws WithdrawalAmountTooLargeException If the withdrawal amount exceeds the available balance plus the overdraft limit.
     */
    @Override
    public int withdraw(int amount) throws WithdrawalAmountTooLargeException {
        if(amount > balance + overdraftLimit) throw new WithdrawalAmountTooLargeException("Balance not enough");
        balance -= amount;
        return balance;
    }

    /**
     * Deposits a specified amount into the savings account's balance.
     *
     * @param amount The amount to be deposited into the account.
     * @return The updated balance after the deposit.
     */
    @Override
    public int deposit(int amount) {
        balance += amount;
        return balance;
    }
}
