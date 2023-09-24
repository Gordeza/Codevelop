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

    /**
     * Opens a new savings account with the specified initial deposit and associates it with the given account ID.
     *
     * @param accountId The unique identifier for the new account.
     * @param amountToDeposit The initial deposit amount for the savings account.
     * @throws AccountCannotBeCreatedException If the account cannot be created, e.g., due to insufficient initial deposit.
     */
    @Override
    public void openSavingsAccount(Long accountId, int amountToDeposit) throws AccountCannotBeCreatedException {
        Account account = new SavingsAccount(amountToDeposit);
        db.addAccount(accountId, account);
    }

    /**
     * Opens a new current account and associates it with the given account ID.
     *
     * @param accountId The unique identifier for the new account.
     * @throws AccountCannotBeCreatedException If the account cannot be created for any reason.
     */
    @Override
    public void openCurrentAccount(Long accountId) throws AccountCannotBeCreatedException {
        Account account = new CurrentAccount();
        db.addAccount(accountId, account);
    }

    /**
     * Withdraws a specified amount from the account associated with the given account ID.
     *
     * @param accountId The unique identifier of the account from which to withdraw.
     * @param amountToWithdraw The amount to be withdrawn.
     * @throws AccountNotFoundException If no account exists with the provided account ID.
     * @throws WithdrawalAmountTooLargeException If the withdrawal amount exceeds the account balance.
     */
    @Override
    public void withdraw(Long accountId, int amountToWithdraw) throws AccountNotFoundException, WithdrawalAmountTooLargeException {
        Account account = db.getAccountById(accountId);
        account.withdraw(amountToWithdraw);
    }

    /**
     * Deposits a specified amount into the account associated with the given account ID.
     *
     * @param accountId The unique identifier of the account into which to deposit.
     * @param amountToDeposit The amount to be deposited.
     * @throws AccountNotFoundException If no account exists with the provided account ID.
     */
    @Override
    public void deposit(Long accountId, int amountToDeposit) throws AccountNotFoundException {
        Account account = db.getAccountById(accountId);
        account.deposit(amountToDeposit);
    }
}
