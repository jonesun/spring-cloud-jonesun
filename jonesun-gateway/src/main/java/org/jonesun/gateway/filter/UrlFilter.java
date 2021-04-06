package org.jonesun.gateway.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * url过滤器
 *
 * @author jone.sun
 * 2021/3/19 17:04
 */
@Component
public class UrlFilter implements GlobalFilter, Ordered {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        String url = request.getURI().getPath();
        //TODO 拦截特定URL地址

        logger.info("url: {}", url);
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 2;
    }
}