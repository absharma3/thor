package com.jarvis.controller;

import com.jarvis.model.FeeSummary;
import com.jarvis.model.Transaction;
import com.jarvis.model.TransactionFactory;
import com.jarvis.reader.CSVFileTransactionReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abhimanyus on 3/23/18.
 */
@Controller
@RequestMapping("/v1/api/fee")
public class TransactionFeeController {

    @Autowired
    TransactionFactory transactionFactory;

    @Autowired
    CSVFileTransactionReader csvFileTransactionReader;

    @RequestMapping(path = "/summary", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody List<FeeSummary> getSummary(){
        List<FeeSummary> summaries = new ArrayList<FeeSummary>();
        csvFileTransactionReader.read();
        for(Transaction transaction : transactionFactory.getTransactions()){
            FeeSummary summary = new FeeSummary();
            summary.setClientId(transaction.getClientId());
            summary.setProcessingFee(transaction.getProcessingFee());
            summary.setTransactionDate(transaction.getTranDate());
            summary.setTransactionType(transaction.transactionType());
            summary.setHighPriority(transaction.isHighPriority());
            summaries.add(summary);
        }
        return summaries;
    }

}
