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

import java.net.InetSocketAddress;

/**
 * Ip过滤器
 *
 * @author jone.sun
 * 2021/3/19 17:03
 */
@Component
public class IpFilter implements GlobalFilter, Ordered {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        InetSocketAddress remoteAddress = request.getRemoteAddress();
        //TODO 设置ip白名单
        logger.info("ip: {}", remoteAddress.getHostName());
        return chain.filter(exchange);
    }
    @Override
    public int getOrder() {
        return 1;
    }
}