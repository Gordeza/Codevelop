package com.acme.test01.mikheiligordeziani.service.impl;

import com.acme.test01.mikheiligordeziani.exception.AccountCannotBeCreatedException;
import com.acme.test01.mikheiligordeziani.exception.AccountNotFoundException;
import com.acme.test01.mikheiligordeziani.exception.WithdrawalAmountTooLargeException;
import com.acme.test01.mikheiligordeziani.model.Account;
import com.acme.test01.mikheiligordeziani.model.CurrentAccount;
import com.acme.test01.mikheiligordeziani.model.SavingsAccount;
import com.acme.test01.mikheiligordeziani.repository.SystemDB;
import com.acme.test01.mikheiligordeziani.service.AccountService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final SystemDB db;

    @Override
    public void openSavingsAccount(Long accountId, int amountToDeposit) throws AccountCannotBeCreatedException {
        Account account = new SavingsAccount(amountToDeposit);
        db.addAccount(accountId, account);
    }

    @Override
    public void openCurrentAccount(Long accountId) throws AccountCannotBeCreatedException {
        Account account = new CurrentAccount();
        db.addAccount(accountId, account);
    }

    @Override
    public void withdraw(Long accountId, int amountToWithdraw) throws AccountNotFoundException, WithdrawalAmountTooLargeException {
        Account account = db.getAccountById(accountId);
        account.withdraw(amountToWithdraw);
    }

    @Override
    public void deposit(Long accountId, int amountToDeposit) throws AccountNotFoundException {
        Account account = db.getAccountById(accountId);
        account.deposit(amountToDeposit);
    }
}
