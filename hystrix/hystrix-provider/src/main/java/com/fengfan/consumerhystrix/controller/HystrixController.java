package com.fengfan.consumerhystrix.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fengfan
 * @description ribbon和hystrix使用
 * @date 2022/5/20 15:31
 */
@RestController
@RequestMapping("/api")
public class HystrixController {
    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/testProviderHystrix")
    //一但调用服务方法失败并抛出了错误信息后，会自动调用@HystrixCommand标注好的fallbackMethod中的指定方法
    @HystrixCommand(fallbackMethod = "processHystrixGet", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "500"), //超时时间
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),//是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),//请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000"),//时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "20")//失败率达到多少跳闸
    })
    public String testProviderHystrix() throws InterruptedException {
        System.out.println("testHystrixCommand被调用了，正常进入后端业务代码块");
        Thread.sleep(1000);
        return "我是服务端" + serverPort;
    }

    public String processHystrixGet() {
        System.out.println("processHystrixGet被调用了，fallbackMethod执行了服务服务降级了！");
        return serverPort + "服务超时，服务降级啦";
    }

}
