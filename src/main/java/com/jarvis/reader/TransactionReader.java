package com.jarvis.reader;

import com.jarvis.model.Transaction;

import java.util.List;

/**
 * Created by abhimanyus on 3/23/18.
 */
public interface TransactionReader {

    List<Transaction> read();
}
