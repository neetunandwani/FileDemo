package com.test.practice.processor;

import com.test.practice.adaptors.SummaryRowAdaptor;
import com.test.practice.enums.Priority;
import com.test.practice.enums.TransactionType;
import com.test.practice.pojo.SummaryRow;
import com.test.practice.pojo.Transaction;

import java.util.List;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.ToLongFunction;
import java.util.stream.Collectors;

import static com.test.practice.enums.Priority.*;
import static com.test.practice.enums.TransactionType.BUY;
import static com.test.practice.enums.TransactionType.DEPOSIT;
import static com.test.practice.enums.TransactionType.SELL;
import static com.test.practice.enums.TransactionType.WITHDRAW;

public class NormalProcessor implements Function<List<Transaction>, List<SummaryRow>> {
     @Override
    public List<SummaryRow> apply(List<Transaction> transactions) {
        ToLongFunction<SummaryRow> highPriority = row -> row.getPriority().equals(HIGH) ? 500L : row.getFee();
        ToLongFunction<SummaryRow> normalSellPriority = row -> row.getPriority().equals(LOW) && (row.getType().equals(SELL) || row.getType().equals(WITHDRAW)) ? 100L : row.getFee();
        ToLongFunction<SummaryRow> normalBuyPriority = row -> row.getPriority().equals(LOW) && (row.getType().equals(BUY) || row.getType().equals(DEPOSIT)) ? 50L : row.getFee();

        return transactions.stream().map(SummaryRowAdaptor::new)
            .peek(row -> row.setFee(highPriority.applyAsLong(row)))
            .peek(row -> row.setFee(normalSellPriority.applyAsLong(row)))
            .peek(row -> row.setFee(normalBuyPriority.applyAsLong(row)))
            .collect(Collectors.toList());

    }
}
