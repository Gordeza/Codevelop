package com.acme.test01.mikheiligordeziani.repository;

import com.acme.test01.mikheiligordeziani.exception.AccountExistsException;
import com.acme.test01.mikheiligordeziani.exception.AccountNotFoundException;
import com.acme.test01.mikheiligordeziani.model.Account;

public interface SystemDB {
    Account getAccountById(Long accountId) throws AccountNotFoundException;
    void addAccount(Long accountId, Account account) throws AccountExistsException;
}
