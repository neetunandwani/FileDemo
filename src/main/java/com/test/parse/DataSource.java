package com.test.parse;

import java.io.FileNotFoundException;
import java.util.List;

public interface DataSource<T> {
    List<T> getData(Class<T> clazz) throws FileNotFoundException;
}
