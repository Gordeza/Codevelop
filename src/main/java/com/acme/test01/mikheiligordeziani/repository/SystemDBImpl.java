package com.acme.test01.mikheiligordeziani.repository;

import com.acme.test01.mikheiligordeziani.exception.AccountExistsException;
import com.acme.test01.mikheiligordeziani.exception.AccountNotFoundException;
import com.acme.test01.mikheiligordeziani.model.Account;
import com.acme.test01.mikheiligordeziani.model.CurrentAccount;
import com.acme.test01.mikheiligordeziani.model.SavingsAccount;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class SystemDBImpl implements SystemDB {
    Map<Long, Account> accounts = new HashMap<>();

    public SystemDBImpl() {
        accounts.put(1L, new SavingsAccount(2000));
        accounts.put(2L, new SavingsAccount(3000));
        accounts.put(3L, new SavingsAccount(4000));
        accounts.put(4L, new CurrentAccount(20_000));
        accounts.put(5L, new CurrentAccount(50_000));
        accounts.put(6L, new CurrentAccount(100_000));
    }

    public SystemDBImpl(List<Account> accountList) {
        for(long l = 0; l < accountList.size(); l++){
            accounts.put(l, accountList.get((int)l));
        }
    }

    /**
     * Retrieves an account by its unique identifier.
     *
     * @param accountId The unique identifier of the account to retrieve.
     * @return The account associated with the specified identifier.
     * @throws AccountNotFoundException If no account exists with the provided identifier.
     */
    @Override
    public Account getAccountById(Long accountId) {
        if(!accounts.containsKey(accountId)) throw new AccountNotFoundException("Account with id: " + accountId + " doesn't exist");
        return accounts.get(accountId);
    }

    /**
     * Adds a new account to the system with the specified unique identifier.
     *
     * @param accountId The unique identifier for the new account.
     * @param account The account to be added.
     * @throws AccountExistsException If an account with the provided identifier already exists.
     */
    @Override
    public void addAccount(Long accountId, Account account) throws AccountExistsException {
        if(accounts.containsKey(accountId)) throw new AccountExistsException("Account with id: " + accountId + " already exists");
        accounts.put(accountId, account);
    }

}
