package org.jonesun.user.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author jone.sun
 * 2021/4/1 16:53
 */
@EnableDiscoveryClient
@SpringBootApplication
public class JonesunUserApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(JonesunUserApiApplication.class, args);
    }

}
