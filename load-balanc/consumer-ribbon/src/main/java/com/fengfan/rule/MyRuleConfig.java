package com.fengfan.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author fengfan
 * @date 2023/3/19 14:50
 * @since JDK1.8
 */
@Configuration
public class MyRuleConfig {
    @Bean
    public IRule iRule() {
        return new ZDYRule();
    }
}
