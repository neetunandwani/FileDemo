package com.test.practice.services;

import com.test.practice.enums.TransactionType;
import com.test.practice.pojo.SummaryRow;
import com.test.practice.pojo.Transaction;
import com.test.practice.processor.IntraDayProcessor;
import com.test.practice.processor.NormalProcessor;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.test.practice.enums.TransactionType.BUY;
import static com.test.practice.enums.TransactionType.SELL;

public class SummaryReportService {
    private static SummaryReportService instance;
    private IntraDayProcessor intraDayProcessor = new IntraDayProcessor();
    private NormalProcessor normalProcessor = new NormalProcessor();

    private SummaryReportService() {
    }

    public static SummaryReportService getInstance() {
        if (instance == null) {
            instance = new SummaryReportService();
        }
        return instance;
    }

    class IntraDayGroup {
        String clientId;
        String securityId;
        Instant date;

        IntraDayGroup(Transaction transaction) {
            this.clientId = transaction.getClientId();
            this.securityId = transaction.getSecurityId();
            this.date = transaction.getDate();
        }

        @Override
        public String toString() {
            return "IntraDayGroup{" +
                "clientId='" + clientId + '\'' +
                ", securityId='" + securityId + '\'' +
                ", date=" + date +
                '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof IntraDayGroup)) return false;
            IntraDayGroup that = (IntraDayGroup) o;
            return Objects.equals(clientId, that.clientId) &&
                Objects.equals(securityId, that.securityId) &&
                Objects.equals(date, that.date);
        }

        @Override
        public int hashCode() {
            return Objects.hash(clientId, securityId, date);
        }
    }

    public List<SummaryRow> generateReport(List<Transaction> transactions) {
        List<SummaryRow> rows = new ArrayList<>();
        Map<String, List<Transaction>> grouped = transactions.stream().collect(Collectors.groupingBy(Transaction::getKey));
        grouped.forEach((key, value) ->
            {
                if (value.size() == 2 && value.stream().anyMatch(transaction -> transaction.getType().equals(BUY)) && value.stream().anyMatch(transaction -> transaction.getType().equals(SELL))) {
                    rows.addAll(intraDayProcessor.process(value));
                } else {
                    rows.addAll(normalProcessor.process(value));
                }
            }
        );
        return rows;
    }

}
