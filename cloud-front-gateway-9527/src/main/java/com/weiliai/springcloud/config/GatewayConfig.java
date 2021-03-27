package com.weiliai.springcloud.config;

import com.weiliai.springcloud.filter.MyLogGateWayFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Doug Li
 * @Date 2021/3/27
 * @Describe: 网关配置, 也可以使用yml
 */
@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder.routes().route(r -> r.path("/guonei")
                .uri("http://news.baidu.com/guonei")
                .id("path_route_news"))
                .build();
    }
}
