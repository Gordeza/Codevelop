package com.acme.test01.mikheiligordeziani.model;

import com.acme.test01.mikheiligordeziani.exception.AccountCannotBeCreatedException;
import com.acme.test01.mikheiligordeziani.exception.WithdrawalAmountTooLargeException;


public class SavingsAccount implements Account {
    private final int MIN_BALANCE = 1_000;

    private int balance;

    public SavingsAccount(int firstDeposit) throws AccountCannotBeCreatedException{
        if(firstDeposit < MIN_BALANCE) throw new AccountCannotBeCreatedException("Account cannot be created. Minimum amount for the first deposit should be R" + MIN_BALANCE);
        balance = firstDeposit;
    }

    @Override
    public int withdraw(int amount) throws WithdrawalAmountTooLargeException{
        if(balance - amount < MIN_BALANCE) throw new WithdrawalAmountTooLargeException("Balance on savings account cannot be less then R1000");
        balance -= amount;
        return balance;
    }

    @Override
    public int deposit(int amount) {
        balance += amount;
        return balance;
    }


}
