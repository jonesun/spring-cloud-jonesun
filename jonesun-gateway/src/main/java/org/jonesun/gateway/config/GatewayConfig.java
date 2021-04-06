package org.jonesun.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.util.pattern.PathPatternParser;

/**
 * 网关配置
 *
 * @author jone.sun
 * 2021/3/19 17:01
 */
@Configuration
public class GatewayConfig {

    /**
     * 跨域配置
     * @return
     */
    @Bean
    public CorsWebFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedMethod("*");//支持所有方法
        config.addAllowedOrigin("*");//跨域处理 允许所有的域
        config.addAllowedHeader("*");//支持所有请求头

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource(new PathPatternParser());
        source.registerCorsConfiguration("/**", config);//匹配所有请求

        return new CorsWebFilter(source);
    }

}
