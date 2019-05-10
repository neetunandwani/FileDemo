package com.test.practice.adaptors;

import com.test.practice.pojo.SummaryRow;
import com.test.practice.pojo.Transaction;

public class SummaryRowAdaptor extends SummaryRow {
    public SummaryRowAdaptor(Transaction transaction) {
        this.setClientId(transaction.getClientId());
        this.setSecurityId(transaction.getSecurityId());
        this.setDate(transaction.getDate());
        this.setPriority(transaction.getPriority());
        this.setType(transaction.getType());
    }
}
