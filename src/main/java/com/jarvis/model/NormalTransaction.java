package com.jarvis.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by abhimanyus on 3/23/18.
 */
public abstract class NormalTransaction implements Transaction {

    private String externalTranId;
    private String clientId;
    private String securityId;
    private Date tranDate;
    private double marketVal;

    public NormalTransaction() {
    }

    public NormalTransaction(String[] lineData) {
        this.externalTranId = lineData[0];
        this.clientId = lineData[1];
        this.securityId = lineData[2];
        try {
            this.tranDate = new SimpleDateFormat("MM/dd/yyyy").parse(lineData[4]);
            this.marketVal = Double.parseDouble(lineData[5]);
        } catch (ParseException e) {
            //TODO should be able to log that unable to process and throw error
        }
    }

    public String getExternalTranId() {
        return externalTranId;
    }

    public String getClientId() {
        return clientId;
    }

    public String getSecurityId() {
        return securityId;
    }

    public Date getTranDate() {
        return tranDate;
    }

    public double getMarketVal() {
        return marketVal;
    }

    @Override
    public int compareTo(Transaction o) {
        if(this.getClientId().equalsIgnoreCase(o.getClientId()) &&
                this.getSecurityId().equalsIgnoreCase(o.getSecurityId())  &&
                this.getTranDate().equals(o.getTranDate()) && this.isOppositeTransactionType(o.transactionType()) )
            return 0;
        else return -1;
    }

    private boolean isOppositeTransactionType(String s) {
        if("Sell".equalsIgnoreCase(this.transactionType()) && "Buy".equalsIgnoreCase(s)){
            return true;
        }else if("Buy".equalsIgnoreCase(this.transactionType()) && "Sell".equalsIgnoreCase(s)){
            return true;
        }
        return false;
    }

    @Override
    public boolean isHighPriority() {
        return false;
    }
}
