package com.test.parse;

import java.util.List;

public class EmployeeCO implements CO {
    private String name;
    private String department;
    private Integer age;
    private Long salary;

    public EmployeeCO(List<String> emp) {
        this.name = emp.get(0);
        this.age = Integer.valueOf(emp.get(1));
        this.department = emp.get(2);
        this.salary = Long.valueOf(emp.get(3));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }


    @Override
    public String toString() {
        return "EmployeeCO{" +
            "name='" + name + '\'' +
            ", department='" + department + '\'' +
            ", age=" + age +
            ", salary=" + salary +
            '}';
    }
}
