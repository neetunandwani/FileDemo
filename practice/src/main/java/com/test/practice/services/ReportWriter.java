package com.test.practice.services;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface ReportWriter<T> {
    void write(String path, T data) throws IOException;
}
