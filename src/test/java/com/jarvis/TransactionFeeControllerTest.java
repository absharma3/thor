package com.jarvis;

import com.jarvis.controller.TransactionFeeController;
import com.jarvis.model.HighPriorityTrasaction;
import com.jarvis.model.Transaction;
import com.jarvis.model.TransactionFactory;
import com.jarvis.reader.CSVFileTransactionReader;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;

/**
 * Created by abhimanyus on 3/24/18.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(value = TransactionFeeController.class, secure = false)
public class TransactionFeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    TransactionFactory transactionFactory;
    @MockBean
    CSVFileTransactionReader csvFileTransactionReader;

    private String[] data1 = {"SAPEXTXN1","GS","ICICI","BUY","11/23/2013","101.9","Y"};

    @Test
    public void testGetSummary() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/v1/api/fee/summary").accept(
                MediaType.APPLICATION_JSON);
        List<Transaction> trasactions = this.getTransactionList();
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        given(csvFileTransactionReader.read()).willReturn(null);
        given(transactionFactory.getTransactions()).willReturn(trasactions);

    }

    private List<Transaction> getTransactionList() {

        List<Transaction> transactions = new ArrayList<Transaction>();
        transactions.add(new HighPriorityTrasaction(data1));
        return transactions;
    }


}
