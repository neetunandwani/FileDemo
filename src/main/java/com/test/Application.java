package com.test;

import com.test.parse.EmployeeCO;
import com.test.parse.DataSource;
import com.test.parse.file.CSVFileDataSource;
import com.test.parse.file.FileDataDataSource;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;

public class Application {
    public static void main(String[] args) throws FileNotFoundException {
//        File file = Optional.ofNullable(Thread.currentThread().getContextClassLoader().getResource("employee.csv"))
//            .map(resource -> {
//                System.out.println(resource.getFile());
//                return new File(resource.getFile());
//            }).orElse(null);
//        System.out.println(file.exists());

        DataSource dataSource = new CSVFileDataSource().setSeparator(",").setName("employee.csv");
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
