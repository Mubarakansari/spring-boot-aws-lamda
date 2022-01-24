package com.springcloud.aws.lambda.respository;

import com.springcloud.aws.lambda.domain.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class EmployeeDao {


    public List<Employee> buildEmployee() {
        return Stream.of(
                new Employee(101, "Raj", "IT", 40000),
                new Employee(102, "Ramesh", "Account", 20000),
                new Employee(278, "Raj", "HR", 10000),
                new Employee(953, "Karan", "Tester", 15000)
        ).collect(Collectors.toList());
    }
}
