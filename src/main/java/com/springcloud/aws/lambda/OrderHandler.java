package com.springcloud.aws.lambda;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.springcloud.aws.lambda.domain.Employee;
import org.springframework.cloud.function.adapter.aws.SpringBootRequestHandler;

import java.util.List;

public class OrderHandler extends SpringBootRequestHandler<APIGatewayProxyRequestEvent, List<Employee>> {
}
