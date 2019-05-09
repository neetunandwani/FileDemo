package com.test.parse.file;

import com.test.parse.EmployeeCO;

import java.util.List;

public class JsonFileDataSource extends FileDataSource<EmployeeCO> {
    public JsonFileDataSource(String name) {
        super(name);
    }

    @Override
    public List<EmployeeCO> getData(Class<EmployeeCO> clazz) {
        return null;
    }
}
