package com.jarvis.model;

/**
 * Created by abhimanyus on 3/23/18.
 */
public abstract class DebitTransaction extends NormalTransaction {
    public DebitTransaction(String[] lineData) {
        super(lineData);
    }

    @Override
    public long getProcessingFee() {
        return 100;
    }
}
