package com.acme.test01.mikheiligordeziani.model;

import com.acme.test01.mikheiligordeziani.exception.AccountCannotBeCreatedException;
import com.acme.test01.mikheiligordeziani.exception.WithdrawalAmountTooLargeException;


public class SavingsAccount implements Account {
    private final int MIN_BALANCE = 1_000;

    private int balance;

    /**
     * Constructs a new SavingsAccount with an initial deposit.
     *
     * @param firstDeposit The initial deposit amount for the account.
     * @throws AccountCannotBeCreatedException If the initial deposit is less than the minimum allowed balance.
     */
    public SavingsAccount(int firstDeposit) throws AccountCannotBeCreatedException{
        if(firstDeposit < MIN_BALANCE) throw new AccountCannotBeCreatedException("Account cannot be created. Minimum amount for the first deposit should be R" + MIN_BALANCE);
        balance = firstDeposit;
    }

    /**
     * Withdraws a specified amount from the savings account's balance.
     *
     * @param amount The amount to be withdrawn from the account.
     * @return The updated balance after the withdrawal.
     * @throws WithdrawalAmountTooLargeException If the withdrawal would result in a balance less than the minimum allowed balance.
     */
    @Override
    public int withdraw(int amount) throws WithdrawalAmountTooLargeException{
        if(balance - amount < MIN_BALANCE) throw new WithdrawalAmountTooLargeException("Balance on savings account cannot be less then R1000");
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
