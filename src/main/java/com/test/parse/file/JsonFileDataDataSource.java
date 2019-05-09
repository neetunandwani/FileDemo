package com.test.parse.file;

import com.test.parse.EmployeeCO;

import java.util.List;

public class JsonFileDataDataSource extends FileDataDataSource<EmployeeCO> {
    @Override
    public List<EmployeeCO> getData(Class<EmployeeCO> clazz) {
        return null;
    }

    @Override
    public boolean isValid(java.io.File file) {
        return file.isFile() && file.getName().endsWith(".json");
    }
}
