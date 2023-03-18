package com.fengfan.consumerfeign.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author fengfan
 * @description OpenFeign客户端接口实现
 * @date 2022/5/23 14:11
 */
@FeignClient(value = "eureka-provider", path = "/provider")
public interface ProviderService {

    @PostMapping("/api/sayHello")
    String sayHello(@RequestParam String name);
}
