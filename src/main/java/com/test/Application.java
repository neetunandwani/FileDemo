package com.test;

import com.test.parse.EmployeeCO;
import com.test.parse.DataSource;
import com.test.parse.file.CSVFileDataSource;

import java.io.IOException;
import java.util.List;

public class Application {
    public static void main(String[] args) throws IOException {
        DataSource dataSource = new CSVFileDataSource("employee.csv").setSeparator(",");
        List<EmployeeCO> employeeCOList = dataSource.getData(EmployeeCO.class);
        if (!employeeCOList.isEmpty()) {
            EmployeeCO data = employeeCOList.stream()
                .filter(employeeCO -> employeeCO.getDepartment().equalsIgnoreCase("JVM"))
                .max((a, b) -> (a.getSalary() > b.getSalary() ? 1 : (a.getSalary() < b.getSalary() ? -1 : 0)))
                .get();
            System.out.println(data);
        } else {
            System.out.println("Invalid file");
        }
    }
}
