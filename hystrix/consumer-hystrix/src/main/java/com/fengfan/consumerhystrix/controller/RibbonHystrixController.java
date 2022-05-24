package com.fengfan.consumerhystrix.controller;

import com.fengfan.consumerhystrix.api.ProviderService;
import com.fengfan.consumerhystrix.service.RibbonHystrixService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author fengfan
 * @description ribbon和hystrix使用
 * @date 2022/5/20 15:31
 */
@RestController
@RequestMapping("/api")
public class RibbonHystrixController {
    @Resource
    private RibbonHystrixService ribbonHystrixService;
    @Resource
    private ProviderService providerService;

    @PostMapping("/testRibbonHystrix")
    public String testRibbonHystrix(){
        return ribbonHystrixService.getServerInfo();
    }

    @PostMapping("/testFeignHystrix")
    public String testFeignHystrix(){
        return providerService.sayHello("consumer-Hystrix");
    }
}
