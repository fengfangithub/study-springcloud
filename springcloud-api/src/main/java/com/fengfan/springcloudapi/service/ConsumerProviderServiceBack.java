package com.fengfan.springcloudapi.service;

import com.fengfan.springcloudapi.entity.Person;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author fengfan
 * @date 2023/3/21 10:47
 * @since JDK1.8
 */
@Component
public class ConsumerProviderServiceBack implements FallbackFactory<ConsumerProviderService> {

    @Override
    public ConsumerProviderService create(Throwable throwable) {
        return new ConsumerProviderService() {
            @Override
            public Person getOne() {
                return null;
            }

            @Override
            public String sayHello(String name) {
                return "服务超时，降级啦";
            }
        };
    }
}
