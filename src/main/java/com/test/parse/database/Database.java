package com.test.parse.database;

import com.test.parse.DataSource;

abstract class Database<T> implements DataSource<T> {
    private String type;

    Database(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

}
