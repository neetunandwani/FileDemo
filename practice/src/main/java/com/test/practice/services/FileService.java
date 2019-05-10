package com.test.practice.services;

import com.test.practice.pojo.Transaction;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

public abstract class FileService {
    private String name;

    FileService(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    public abstract List<Transaction> read() throws IOException;

    public abstract boolean isValid(String fileName);

    public InputStream getFile() {
        return Optional.ofNullable(Thread.currentThread()
            .getContextClassLoader()
            .getResourceAsStream(name))
            .orElse(null);
    }
}
