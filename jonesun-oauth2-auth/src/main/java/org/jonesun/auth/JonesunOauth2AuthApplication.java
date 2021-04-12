package org.jonesun.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author jone.sun
 * 2021/4/8 18:17
 */
@EnableDiscoveryClient
@SpringBootApplication
public class JonesunOauth2AuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(JonesunOauth2AuthApplication.class);
    }

}
