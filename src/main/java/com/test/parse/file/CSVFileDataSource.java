package com.test.parse.file;

import com.test.parse.CO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.*;

public class CSVFileDataSource extends FileDataDataSource<CO> {
    private String separator = ",";

    public String getSeparator() {
        return separator;
    }

    public CSVFileDataSource setSeparator(String separator) {
        this.separator = separator;
        return this;
    }

    @Override
    public List<CO> getData(Class clazz) throws FileNotFoundException {
        java.io.File file = getFile();
        if (!isValid(file)) {
            return Collections.emptyList();
        }
        List<String> lines = new BufferedReader(new FileReader(file)).lines().skip(1).collect(Collectors.toList());
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

    @Override
    public boolean isValid(File file) {
        return (file != null) && file.isFile() && file.getName().endsWith(".csv");
    }
}
