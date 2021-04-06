package org.jonesun.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * api网关启动类
 *
 * @author jone.sun
 * 2021/3/19 16:59
 */
@EnableDiscoveryClient
@SpringBootApplication
public class JonesunGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(JonesunGatewayApplication.class, args);
    }

}
