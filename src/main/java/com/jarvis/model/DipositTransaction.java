package com.jarvis.model;

/**
 * Created by abhimanyus on 3/23/18.
 */
public class DipositTransaction extends CreditTransaction {
    public DipositTransaction(String[] lineData) {
        super(lineData);
    }

    @Override
    public String transactionType() {
        return "Deposit";
    }
}
