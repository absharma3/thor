package com.jarvis.model;

import java.util.Date;

/**
 * Created by abhimanyus on 3/23/18.
 */
public class IntradayTransaction implements Transaction {

    Transaction buyTransaction;
    Transaction sellTransaction;

    public IntradayTransaction(Transaction transaction, Transaction reverseTransaction) {
        super();
        this.buyTransaction = transaction;
        this.sellTransaction = reverseTransaction;
    }

    @Override
    public long getProcessingFee() {
        return 10;
    }

    @Override
    public String transactionType() {
        return "Intraday Transaction";
    }

    @Override
    public String getClientId() {
        return this.buyTransaction.getClientId();
    }

    @Override
    public String getSecurityId() {
        return this.buyTransaction.getSecurityId();
    }

    @Override
    public Date getTranDate() {
        return this.buyTransaction.getTranDate();
    }

    @Override
    public boolean isHighPriority() {
        return false;
    }

    @Override
    public int compareTo(Transaction o) {
        return 0;
    }
}
