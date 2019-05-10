package com.test.practice.adaptors;

import com.test.practice.enums.Priority;
import com.test.practice.enums.TransactionType;
import com.test.practice.pojo.Transaction;

import java.time.Instant;

public class TransactionDataAdaptor extends Transaction {

    public TransactionDataAdaptor(String[] properties) {
        this.setId(properties[0]);
        this.setClientId(properties[1]);
        this.setSecurityId(properties[2]);
        this.setDate(Instant.parse(properties[3]));
        this.setType(TransactionType.valueOf(properties[4]));
        this.setPriority(Priority.valueOf(properties[5].toUpperCase()));
    }


}
