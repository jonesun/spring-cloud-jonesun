package org.jonesun.admin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 服务管理启动类
 *
 * @author jone.sun
 * 2021/3/18 18:36
 */
@EnableDiscoveryClient
@EnableAdminServer
@SpringBootApplication
public class JonesunAdminServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(JonesunAdminServerApplication.class, args);
    }

}
