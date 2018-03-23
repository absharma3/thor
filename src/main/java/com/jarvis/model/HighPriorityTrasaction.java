package com.jarvis.model;

/**
 * Created by abhimanyus on 3/23/18.
 */
public class HighPriorityTrasaction extends NormalTransaction {

    private String transactionType;

    public HighPriorityTrasaction(String[] lineData) {
        super(lineData);
        this.transactionType = lineData[3];
    }

    @Override
    public long getProcessingFee() {
        return 500;
    }

    @Override
    public String transactionType() {
        return this.transactionType;
    }

    @Override
    public boolean isHighPriority() {
        return true;
    }
}
