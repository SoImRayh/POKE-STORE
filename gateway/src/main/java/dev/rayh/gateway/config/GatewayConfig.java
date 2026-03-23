package dev.rayh.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class GatewayConfig {

    @Bean
    public RouteLocator routeLocator (RouteLocatorBuilder builder) {
        return builder.routes().
                route("test", r -> r.path("/").uri("https://www.google.com/"))
                .route("api_resource", r -> r.path("/api/**").uri("http://localhost:8081/"))
                .route("api-auth", r -> r.path("/auth/**").uri("http://localhost:8082/"))
                .build();

    }

}
