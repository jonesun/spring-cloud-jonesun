package org.jonesun.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author jone.sun
 * 2021/3/19 17:39
 */
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class JonesunDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(JonesunDemoApplication.class, args);
    }

    @RestController
    static class TestController {

        @Autowired
        LoadBalancerClient loadBalancerClient;

        @GetMapping("")
        public String test() {
//            return "hello jone sun demo";
//            //直接访问jonesun-user-api
//            ServiceInstance serviceInstance = loadBalancerClient.choose("jonesun-user-api");
//            String url = serviceInstance.getUri() + "/api/users";
//            RestTemplate restTemplate = new RestTemplate();
//            String result = restTemplate.getForObject(url, String.class);
//            return "Invoke : " + url + ", return : " + result;

            //通过网关jonesun-gateway访问jonesun-user-api
            ServiceInstance serviceInstance = loadBalancerClient.choose("jonesun-gateway");
            String url = serviceInstance.getUri() + "/jonesun-user-api/api/users";
            RestTemplate restTemplate = new RestTemplate();
            String result = restTemplate.getForObject(url, String.class);
            return "Invoke : " + url + ", return : " + result;
        }
    }


}
