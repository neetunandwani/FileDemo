package com.test.parse.database;

import com.test.parse.EmployeeCO;

import java.io.FileNotFoundException;
import java.util.List;

public class MySql extends Database<EmployeeCO> {

    String databaseName = "company";
    String tableName = "employee";

    public MySql() {
        super("mysql");
    }


    @Override
    public List<EmployeeCO> getData(Class<EmployeeCO> clazz) throws FileNotFoundException {
        return null;
    }
}
