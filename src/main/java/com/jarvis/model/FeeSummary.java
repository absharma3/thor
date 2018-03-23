package com.jarvis.model;

import java.util.Date;

/**
 * Created by abhimanyus on 3/23/18.
 */
public class FeeSummary {

    private String clientId;
    private String transactionType;
    private Date transactionDate;
    private boolean isHighPriority;
    private long processingFee;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public boolean isHighPriority() {
        return isHighPriority;
    }

    public void setHighPriority(boolean highPriority) {
        isHighPriority = highPriority;
    }

    public long getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(long processingFee) {
        this.processingFee = processingFee;
    }
}
