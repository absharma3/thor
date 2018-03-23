package com.jarvis.reader;

import com.jarvis.model.Transaction;
import com.jarvis.model.TransactionFactory;
import org.apache.commons.io.LineIterator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

/**
 * Created by abhimanyus on 3/23/18.
 */
@Component
public class CSVFileTransactionReader extends AbstractTransactionReader {

    @Autowired
    TransactionFactory transactionFactory;


    @Override
    public List<Transaction> read() {
        try {
            LineIterator it = super.readFile();
            //Skipping first line as it doesn't contain any data
            it.nextLine();
            while (it.hasNext()) {
                String line = it.nextLine();
                String[] lineData = line.split(",");
                transactionFactory.getTransaction(lineData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return transactionFactory.getTransactions();
    }
}
