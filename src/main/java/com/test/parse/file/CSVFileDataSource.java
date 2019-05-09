package com.test.parse.file;

import com.test.parse.CO;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.*;

public class CSVFileDataSource extends FileDataSource<CO> {
    private String separator = ",";

    public CSVFileDataSource(String name) {
        super(name);
    }

    public String getSeparator() {
        return separator;
    }

    public CSVFileDataSource setSeparator(String separator) {
        this.separator = separator;
        return this;
    }

    @Override
    public List<CO> getData(Class clazz) {
        InputStream url = getFile();
        List<String> lines = new BufferedReader(new InputStreamReader(url, Charset.defaultCharset()))
            .lines()
            .skip(1)
            .collect(Collectors.toList());
        return lines.stream().map(line -> {
            CO obj = null;
            try {
                Constructor constructor = clazz.getConstructor(List.class);
                obj = (CO) constructor.newInstance(asList(line.split(separator)));
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            return obj;
        }).collect(Collectors.toList());
    }

}
