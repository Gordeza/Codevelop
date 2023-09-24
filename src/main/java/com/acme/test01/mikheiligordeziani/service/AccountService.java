package com.acme.test01.mikheiligordeziani.service;

import com.acme.test01.mikheiligordeziani.exception.AccountCannotBeCreatedException;
import com.acme.test01.mikheiligordeziani.exception.AccountNotFoundException;
import com.acme.test01.mikheiligordeziani.exception.WithdrawalAmountTooLargeException;

public interface AccountService {
    void openSavingsAccount(Long accountId, int amountToDeposit) throws AccountCannotBeCreatedException;
    void openCurrentAccount(Long accountId);
    void withdraw(Long accountId, int amountToWithdraw) throws AccountNotFoundException, WithdrawalAmountTooLargeException;
    void deposit(Long accountId, int amountToDeposit)  throws AccountNotFoundException;
}
