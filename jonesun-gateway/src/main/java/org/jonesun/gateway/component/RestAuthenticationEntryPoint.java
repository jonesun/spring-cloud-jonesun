package org.jonesun.gateway.component;

import cn.hutool.json.JSONUtil;
import org.jonesun.gateway.api.CommonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.server.ServerAuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.function.BiConsumer;

/**
 * 自定义返回结果：没有登录或token过期时
 *
 * @author jone.sun
 * 2021/4/12 13:03
 */
@Component
public class RestAuthenticationEntryPoint implements ServerAuthenticationEntryPoint {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public Mono<Void> commence(ServerWebExchange exchange, AuthenticationException e) {
        ServerHttpResponse response = exchange.getResponse();
        response.setStatusCode(HttpStatus.OK);
        response.getHeaders().add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        String body = JSONUtil.toJsonStr(CommonResult.unauthorized(e.getMessage()));
        response.getHeaders().set(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "*");
        response.getHeaders().set(HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS, "*");
        response.getHeaders().set(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS, "*");


        if (exchange.getRequest().getMethod() == HttpMethod.OPTIONS) {
            response.setStatusCode(HttpStatus.OK);
            return Mono.empty();
        }
        logger.info("url->{} method: {} body: {}", exchange.getRequest().getPath(),  exchange.getRequest().getMethod(), body);
//        exchange.getRequest().getHeaders().forEach(new BiConsumer<String, List<String>>() {
//            @Override
//            public void accept(String s, List<String> strings) {
//                logger.info("requestHeader->{} values: {}", s, JSONUtil.toJsonStr(strings));
//            }
//        });
//        exchange.getResponse().getHeaders().forEach(new BiConsumer<String, List<String>>() {
//            @Override
//            public void accept(String s, List<String> strings) {
//                logger.info("responseHeader->{} values: {}", s, JSONUtil.toJsonStr(strings));
//            }
//        });

        DataBuffer buffer = response.bufferFactory().wrap(body.getBytes(StandardCharsets.UTF_8));
        return response.writeWith(Mono.just(buffer));
    }
}
