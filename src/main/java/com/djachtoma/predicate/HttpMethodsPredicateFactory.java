package com.djachtoma.predicate;

import org.springframework.cloud.gateway.handler.predicate.MethodRoutePredicateFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.server.ServerWebExchange;

import java.util.function.Predicate;
import java.util.stream.Stream;

import static jakarta.ws.rs.HttpMethod.*;


@Configuration
public class HttpMethodsPredicateFactory extends MethodRoutePredicateFactory {



    @Override
    public Predicate<ServerWebExchange> apply(Config config) {
        return (ServerWebExchange request) -> {
            HttpMethod httpMethod = request.getRequest().getMethod();
            return Stream.of(httpMethod)
                    .anyMatch(method -> method.matches(GET) || method.matches(POST)
                              || method.matches(PATCH) || method.matches(DELETE));
        };
    }

}
