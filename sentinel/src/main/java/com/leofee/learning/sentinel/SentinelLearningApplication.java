package com.leofee.learning.sentinel;

import com.alibaba.cloud.nacos.ribbon.NacosRule;
//import com.netflix.loadbalancer.IRule;
import feign.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author leofee
 */
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class SentinelLearningApplication {

    public static void main(String[] args) {
        SpringApplication.run(SentinelLearningApplication.class);
    }

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public Logger.Level feignLoggerLevel(){
        //开启详细日志
        return Logger.Level.FULL;
    }
}
