package com.fengfan.consumerfeign.controller;

import com.fengfan.springcloudapi.entity.Person;
import com.fengfan.springcloudapi.service.ConsumerProviderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author fengfan
 * @date 2023/3/19 16:13
 * @since JDK1.8
 */
@RestController
@RequestMapping("/test")
public class ConsumerFeignController {
    @Resource
    private ConsumerProviderService consumerProviderService;

    @PostMapping("getOne")
    public Person getOne(){
        return consumerProviderService.getOne();
    }

    @PostMapping("requestHello")
    public String requestHello(){
        return consumerProviderService.sayHello("feign8092");
    }

}
