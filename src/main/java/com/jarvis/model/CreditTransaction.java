package com.jarvis.model;

/**
 * Created by abhimanyus on 3/23/18.
 */
public abstract class CreditTransaction extends NormalTransaction {
    public CreditTransaction(String[] lineData) {
        super(lineData);
    }

    @Override
    public long getProcessingFee() {
        return 50;
    }


}
