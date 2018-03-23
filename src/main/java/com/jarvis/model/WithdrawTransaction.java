package com.jarvis.model;

/**
 * Created by abhimanyus on 3/23/18.
 */
public class WithdrawTransaction extends DebitTransaction {
    public WithdrawTransaction(String[] lineData) {
        super(lineData);
    }

    @Override
    public String transactionType() {
        return "Withdraw";
    }
}
