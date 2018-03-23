package com.jarvis.model;

/**
 * Created by abhimanyus on 3/23/18.
 */
public class WithdrawTrasaction extends DebitTransaction {
    public WithdrawTrasaction(String[] lineData) {
        super(lineData);
    }

    @Override
    public String transactionType() {
        return "Withdraw";
    }
}
