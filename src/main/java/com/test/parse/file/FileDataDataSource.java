package com.test.parse.file;

import com.test.parse.DataSource;

import java.io.File;
import java.util.Optional;

public abstract class FileDataDataSource<T> implements DataSource<T> {
    private String name;

    public String getName() {
        return name;
    }

    public FileDataDataSource setName(String name) {
        this.name = name;
        return this;
    }

    public abstract boolean isValid(java.io.File file);

    final File getFile() {
        System.out.println(name);
        return Optional.ofNullable(Thread.currentThread().getContextClassLoader().getResource(name))
            .map(resource -> new File(resource.getFile())).orElse(null);
    }
}
