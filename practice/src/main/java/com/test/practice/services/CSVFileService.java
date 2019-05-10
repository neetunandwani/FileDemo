package com.test.practice.services;

import com.test.practice.adaptors.TransactionDataAdaptor;
import com.test.practice.pojo.SummaryRow;
import com.test.practice.pojo.Transaction;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

public class CSVFileService extends FileService implements ReportWriter<List<SummaryRow>> {
    private String SEPARATOR = ",";

    CSVFileService(String name) {
        super(name);
    }

    public CSVFileService setSEPARATOR(String SEPARATOR) {
        this.SEPARATOR = SEPARATOR;
        return this;
    }

    @Override
    public List<Transaction> read() {
        List<Transaction> transactions = Collections.emptyList();
        if (isValid(getName())) {
            InputStream inputStream = getFile();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, Charset.defaultCharset()));
            transactions = reader.lines().skip(1).map(line -> new TransactionDataAdaptor(line.split(SEPARATOR))).collect(Collectors.toList());
        }
        return transactions;
    }

    @Override
    public boolean isValid(String fileName) {
        return fileName.endsWith(".csv");
    }

    private Function<SummaryRow, String> csvFormat = row ->
        Stream.of(row.getClientId(), row.getSecurityId(), row.getType().name(), row.getDate().toString(), row.getPriority().name(), row.getFee().toString())
            .collect(joining(","));

    @Override
    public void write(String path, List<SummaryRow> data) throws IOException {
        FileOutputStream outputStream = new FileOutputStream(path);
        outputStream.write(data.stream().map(row -> csvFormat.apply(row)).collect(Collectors.joining("\n")).getBytes());
        outputStream.close();
    }
}
