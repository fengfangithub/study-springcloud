package com.fengfan.consumerribbon.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author fengfan
 * @description ribbon负载策略配置
 * @date 2022/5/20 16:14
 */
@Configuration
public class RibbonConfig {

    /**
     * @return com.netflix.loadbalancer.IRule
     * @description 配置随机负载策略
     * @author fengfan
     * @date 2022/5/20 16:04
     */
    @Bean
    public IRule iRule(){
        return new RandomRule();
    }
}
