package com.fengfan.consumerfeign.controller;

import com.fengfan.consumerfeign.api.ProviderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author fengfan
 * @description 调用实现
 * @date 2022/5/23 14:22
 */
@RestController
@RequestMapping("/api")
public class ConsumerFeignController {
    @Resource
    private ProviderService providerService;

    @PostMapping("/getServerInfo")
    public String getServerInfo(){
        return providerService.sayHello("consumer-feign");
    }
}
