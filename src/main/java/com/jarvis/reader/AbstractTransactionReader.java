package com.jarvis.reader;

import com.jarvis.model.Transaction;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.springframework.beans.factory.annotation.Value;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by abhimanyus on 3/23/18.
 */
public abstract class AbstractTransactionReader implements TransactionReader {

    @Value("${transaction.csv.file.name}")
    private String filePath;

    public LineIterator readFile() throws IOException {
        LineIterator it = FileUtils.lineIterator(new File(filePath), "UTF-8");
        return it;
    }
}
