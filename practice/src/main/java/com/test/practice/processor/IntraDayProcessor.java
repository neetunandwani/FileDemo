package com.test.practice.processor;

import com.test.practice.adaptors.SummaryRowAdaptor;
import com.test.practice.pojo.SummaryRow;
import com.test.practice.pojo.Transaction;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class IntraDayProcessor implements Function<List<Transaction>, List<SummaryRow>> {

    @Override
    public List<SummaryRow> apply(List<Transaction> transactions) {
        return transactions.stream().map(SummaryRowAdaptor::new).peek(row -> row.setFee(10l)).collect(Collectors.toList());
    }
}
