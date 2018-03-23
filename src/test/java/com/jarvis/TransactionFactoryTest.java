package com.jarvis;

import com.jarvis.model.*;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by abhimanyus on 3/24/18.
 */

public class TransactionFactoryTest {

    private String[] data1 = {"SAPEXTXN1","GS","ICICI","BUY","11/23/2013","101.9","Y"};
    private String[] data2 = {"SAPEXTXN2","AS","REL","SELL","11/20/2013","121.9","N"};
    private String[] data3 = {"SAPEXTXN2","AS","REL","BUY","11/20/2013","121.9","N"};
    private String[] data4 = {"SAPEXTXN2","AS","REL","DEPOSIT","11/20/2013","121.9","N"};
    private String[] data5 = {"SAPEXTXN2","AS","REL","WITHDRAW","11/20/2013","121.9","N"};

    @Test
    public void testGetTransaction1(){
        TransactionFactory transactionFactory = new TransactionFactory();
        Transaction transaction = transactionFactory.getTransaction(data1);
        Assert.assertNotNull(transaction);
        Assert.assertEquals(transaction.getClientId(), this.getTransaction().getClientId());
        Assert.assertEquals(transaction.getSecurityId(), this.getTransaction().getSecurityId());
        Assert.assertTrue(transaction instanceof HighPriorityTrasaction);
    }

    @Test
    public void testGetTransaction2(){

        TransactionFactory transactionFactory = new TransactionFactory();
        Transaction transaction = transactionFactory.getTransaction(data2);
        Assert.assertNotNull(transaction);
        Assert.assertTrue(transaction instanceof SellTransaction);
    }

    @Test
    public void testGetTransaction3(){

        TransactionFactory transactionFactory = new TransactionFactory();
        Transaction transaction = transactionFactory.getTransaction(data3);
        Assert.assertNotNull(transaction);
        Assert.assertTrue(transaction instanceof BuyTransaction);
    }

    @Test
    public void testGetTransaction4(){

        TransactionFactory transactionFactory = new TransactionFactory();
        Transaction transaction = transactionFactory.getTransaction(data4);
        Assert.assertNotNull(transaction);
        Assert.assertTrue(transaction instanceof DipositTransaction);
    }

    @Test
    public void testGetTransaction5(){

        TransactionFactory transactionFactory = new TransactionFactory();
        Transaction transaction = transactionFactory.getTransaction(data5);
        Assert.assertNotNull(transaction);
        Assert.assertTrue(transaction instanceof WithdrawTransaction);
    }

    @Test
    public void testGetTransaction6(){

        TransactionFactory transactionFactory = new TransactionFactory();
        Transaction transaction = transactionFactory.getTransaction(data2);
        Transaction transaction1 = transactionFactory.getTransaction(data3);
        Assert.assertNotNull(transaction);
        Assert.assertTrue(transaction1 instanceof IntradayTransaction);
    }

    private Transaction getTransaction() {
        return new HighPriorityTrasaction(data1);
    }

}
