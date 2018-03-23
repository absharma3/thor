package com.jarvis.model;

/**
 * Created by abhimanyus on 3/23/18.
 */
public class BuyTransaction extends CreditTransaction{


    public BuyTransaction(String[] lineData) {
        super(lineData);
    }

    @Override
    public String transactionType() {
        return "Buy";
    }
}
