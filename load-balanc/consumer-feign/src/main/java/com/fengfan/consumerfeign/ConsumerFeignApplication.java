package com.fengfan.consumerfeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

//扫描com.xx下的所有包，如果fallback不在同一级或子级包下面需要添加其共同父级包路径
@SpringBootApplication(scanBasePackages = "com.fengfan")
@EnableEurekaClient
//默认扫描当前注解所在包的同级和子级，若不在同一级或子级，需要申明其Feign客户端所在包路径
@EnableFeignClients(basePackages = "com.fengfan.springcloudapi")
@EnableCircuitBreaker
public class ConsumerFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerFeignApplication.class, args);
    }

}
