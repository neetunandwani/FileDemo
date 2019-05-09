package com.test.parse.file;

import com.test.parse.DataSource;

import java.io.InputStream;
import java.util.Optional;

abstract class FileDataSource<T> implements DataSource<T> {
    private String name;

    FileDataSource(String name) {
        this.name = name;
    }

    final InputStream getFile() {
        return Optional.ofNullable(Thread.currentThread().getContextClassLoader().getResourceAsStream(name)).orElse(null);
    }
}
