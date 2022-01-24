package com.springcloud.aws.lambda;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.springcloud.aws.lambda.domain.Employee;
import com.springcloud.aws.lambda.respository.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@SpringBootApplication
public class SpringbootAwsLambdaApplication {

    @Autowired
    private EmployeeDao employeeDao;

    @Bean
    public Supplier<List<Employee>> employee() {
        return () -> employeeDao.buildEmployee();
    }

    @Bean
    public Function<APIGatewayProxyRequestEvent, List<Employee>> findEmployeeByName() {
        return (requestEvent) -> employeeDao.buildEmployee()
                .stream()
                .filter(employee -> employee.getName().equals(requestEvent.getQueryStringParameters().get("employeeName")))
                .collect(Collectors.toList());
    }


    public static void main(String[] args) {
        SpringApplication.run(SpringbootAwsLambdaApplication.class, args);
        System.out.println("================Application Start====================");
    }

}
