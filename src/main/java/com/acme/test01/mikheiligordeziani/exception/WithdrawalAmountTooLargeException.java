package com.acme.test01.mikheiligordeziani.exception;

public class WithdrawalAmountTooLargeException extends RuntimeException {
    public WithdrawalAmountTooLargeException(String message) {
        super(message);
    }
}
