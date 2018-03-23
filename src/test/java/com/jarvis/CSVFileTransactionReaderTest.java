package com.jarvis;

import com.jarvis.reader.CSVFileTransactionReader;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by abhimanyus on 3/23/18.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class CSVFileTransactionReaderTest {

    @Autowired
    CSVFileTransactionReader csvFileTransactionReader;

    

    @Test
    public void testRead(){
        csvFileTransactionReader.read();
    }

}
