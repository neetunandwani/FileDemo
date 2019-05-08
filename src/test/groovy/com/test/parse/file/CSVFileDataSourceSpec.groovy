package com.test.parse.file

import spock.lang.Specification

class CSVFileDataSourceSpec extends Specification {
    def "Test getFile: failure"() {
        when:
        FileDataDataSource file = new CSVFileDataSource().setSeparator(separator).setName(name)
        java.io.File file1 = file.getFile()

        then:
        file1 == null

        where:
        separator | name
        ","       | "test.csv"
        ","       | "employee.json"
    }

    def "Test getFile: success"() {
        when:
        FileDataDataSource file = new CSVFileDataSource().setSeparator(separator).setName(name)
        java.io.File file1 = file.getFile()

        then:
        file1 != null
        file1.name == name

        where:
        separator | name
        ","       | "employee.csv"
    }
}

