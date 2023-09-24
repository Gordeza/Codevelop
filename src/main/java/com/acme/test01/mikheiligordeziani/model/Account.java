package com.acme.test01.mikheiligordeziani.model;


import com.acme.test01.mikheiligordeziani.exception.WithdrawalAmountTooLargeException;

public interface Account {
    int withdraw(int amount) throws WithdrawalAmountTooLargeException;
    int deposit(int amount);
}
