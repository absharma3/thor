package com.jarvis.model;

/**
 * Created by abhimanyus on 3/23/18.
 */
public class HighPriorityTrasaction extends NormalTransaction {
    public HighPriorityTrasaction(String[] lineData) {
        super(lineData);
    }

    @Override
    public long getProcessingFee() {
        return 500;
    }

    @Override
    public String transactionType() {
        return "High Priority";
    }

    @Override
    public boolean isHighPriority() {
        return true;
    }
}
