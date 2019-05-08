package com.test.parse.database;

import com.test.parse.EmployeeCO;

import java.util.List;

public class MongoDb extends Database<EmployeeCO> {
    String database = "company";
    String collection = "employee";

    MongoDb() {
        super("mongodb");
    }

    @Override
    public List<EmployeeCO> getData(Class<EmployeeCO> clazz) {
        //connect with database
        //fetch data
        //create object
        return null;
    }
}
