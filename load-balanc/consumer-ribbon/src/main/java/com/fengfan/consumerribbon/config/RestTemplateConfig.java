package com.fengfan.consumerribbon.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author fengfan
 * @description RestTemplate配置
 * @date 2022/5/18 14:41
 */
@Configuration
public class RestTemplateConfig {

    /**
     * @return org.springframework.web.client.RestTemplate
     * @description 注入一个可以进行负载均衡的RestTemple用于服务问调用
     * @author fengfan
     * @date 2022/5/18 14:43
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
