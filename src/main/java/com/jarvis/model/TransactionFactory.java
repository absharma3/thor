package com.jarvis.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abhimanyus on 3/23/18.
 */
@Component
public class TransactionFactory {

    private List<Transaction> transactions = new ArrayList<Transaction>();

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public Transaction getTransaction(String[] lineData) {

        if(lineData == null || lineData.length <7)
            return null;
        //check if priority flag is set
        if("Y".equalsIgnoreCase(lineData[6])){
            Transaction transaction = new HighPriorityTrasaction(lineData);
            this.transactions.add(transaction);
            return transaction;
        }
        if("Withdraw".equalsIgnoreCase(lineData[3])){
            Transaction transaction = new WithdrawTransaction(lineData);
            this.transactions.add(transaction);
            return transaction;
        }

        if("Deposit".equalsIgnoreCase(lineData[3])){
            Transaction transaction =  new DipositTransaction(lineData);
            this.transactions.add(transaction);
            return transaction;
        }

        if("Sell".equalsIgnoreCase(lineData[3])){
            Transaction transaction = new SellTransaction(lineData);
            return this.findAndUpdateTransactions(transaction);
        }

        if("Buy".equalsIgnoreCase(lineData[3])){
            Transaction transaction = new BuyTransaction(lineData);
            return this.findAndUpdateTransactions(transaction);
        }
        return null;

    }


    private Transaction findAndUpdateTransactions(Transaction transaction){
        for(Transaction reverseTransaction: transactions){
            if(reverseTransaction.compareTo(transaction) == 0){
                this.transactions.remove(reverseTransaction);
                Transaction transaction1 = new IntradayTransaction(transaction, reverseTransaction);
                this.transactions.add(transaction1);
                return transaction1;
            }
        }
        this.transactions.add(transaction);
        return transaction;
    }

}
