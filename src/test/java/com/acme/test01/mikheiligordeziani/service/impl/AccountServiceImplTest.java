package com.acme.test01.mikheiligordeziani.service.impl;

import com.acme.test01.mikheiligordeziani.exception.AccountCannotBeCreatedException;
import com.acme.test01.mikheiligordeziani.exception.AccountExistsException;
import com.acme.test01.mikheiligordeziani.exception.WithdrawalAmountTooLargeException;
import com.acme.test01.mikheiligordeziani.repository.SystemDB;
import com.acme.test01.mikheiligordeziani.repository.SystemDBImpl;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AccountServiceImplTest {

    private SystemDB systemDB = new SystemDBImpl(new ArrayList<>());
    private AccountServiceImpl accountService = new AccountServiceImpl(systemDB);


    @Test
    void openSavingsAccount() {
        accountService.openSavingsAccount(100L, 2000);
        assertThrows(AccountExistsException.class, () -> accountService.openSavingsAccount(100L, 2000));
    }

    @Test
    void withdrawSaving() {
        accountService.openSavingsAccount(200L, 2000);
        accountService.withdraw(200L, 1000);
        assertThrows(WithdrawalAmountTooLargeException.class, () -> accountService.withdraw(200L, 1000));
    }

    @Test
    void depositSaving() {
        accountService.openSavingsAccount(700L, 2000);
        accountService.withdraw(700L, 1000);
        assertThrows(WithdrawalAmountTooLargeException.class, () -> accountService.withdraw(700L, 1000));
        accountService.deposit(700L, 1000);
        accountService.withdraw(700L, 1000);
        assertThrows(WithdrawalAmountTooLargeException.class, () -> accountService.withdraw(700L, 1000));
    }

    @Test
    void openCurrentAccount() {
        accountService.openCurrentAccount(300L);
        assertThrows(AccountExistsException.class, () -> accountService.openCurrentAccount(300L));
    }

    @Test
    void withdrawCurrent() {
        accountService.openCurrentAccount(400L);
        accountService.withdraw(400L, 20_000);
        accountService.withdraw(400L, 30_000);
        assertThrows(WithdrawalAmountTooLargeException.class, () -> accountService.withdraw(400L, 1000));
    }



    @Test
    void depositCurrent() {
        accountService.openCurrentAccount(500L);
        accountService.withdraw(500L, 20_000);
        accountService.withdraw(500L, 30_000);
        assertThrows(WithdrawalAmountTooLargeException.class, () -> accountService.withdraw(500L, 1000));
        accountService.deposit(500L, 1000);
        accountService.withdraw(500L, 1000);
        assertThrows(WithdrawalAmountTooLargeException.class, () -> accountService.withdraw(500L, 1000));

    }
}