package com.jarvis.model;

import java.util.Date;

/**
 * Created by abhimanyus on 3/23/18.
 */
public interface Transaction extends  Comparable<Transaction> {

    long getProcessingFee();

    String transactionType();

    String getClientId();

    String getSecurityId();

    Date getTranDate();

    boolean isHighPriority();
}
