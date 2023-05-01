package com.djachtoma.predicate;

import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.server.ServerWebExchange;

import java.util.function.Predicate;
import java.util.stream.Stream;

import static com.djachtoma.predicate.HttpMethodsPredicateFactory.Config.*;

@Configuration
public class HttpMethodsPredicateFactory extends AbstractRoutePredicateFactory<HttpMethodsPredicateFactory.Config> {


    public HttpMethodsPredicateFactory(Class<Config> configClass) {
        super(configClass);
    }

    @Override
    public Predicate<ServerWebExchange> apply(Config config) {
        return (ServerWebExchange request) -> {
            HttpMethod httpMethod = request.getRequest().getMethod();
            return Stream.of(httpMethod)
                    .anyMatch(method -> method.matches(GET) || method.matches(POST)
                              || method.matches(PATCH) || method.matches(DELETE));
        };
    }

    @Validated
    @Component
    public static class Config {

        public static final String GET = "GET";
        public static final String POST = "POST";
        public static final String PATCH = "PATCH";
        public static final String DELETE = "DELETE";
    }

}
