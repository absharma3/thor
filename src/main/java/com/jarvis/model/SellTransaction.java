package com.jarvis.model;

/**
 * Created by abhimanyus on 3/23/18.
 */
public class SellTransaction extends DebitTransaction{
    public SellTransaction(String[] lineData) {
        super(lineData);
    }

    @Override
    public String transactionType() {
        return "Sell";
    }
}
