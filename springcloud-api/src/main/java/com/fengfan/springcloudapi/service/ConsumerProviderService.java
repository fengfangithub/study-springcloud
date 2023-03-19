package com.fengfan.springcloudapi.service;

import com.fengfan.springcloudapi.entity.Person;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author fengfan
 * @date 2023/3/19 17:01
 * @since JDK1.8
 */
@FeignClient(value = "EUREKA-PROVIDER")
public interface ConsumerProviderService {

    /**
     * 获取人员信息
     *
     * @return
     */
    @PostMapping("/api/getOne")
    Person getOne();
}
