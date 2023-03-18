package com.fengfan.eurekaprovider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author fengfan
 * @description 服务提供者
 * @date 2022/5/18 11:30
 */
@RestController
@RequestMapping("/api")
public class ProviderController {
    @Autowired
    private DiscoveryClient client;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/discovery")
    public Object discovery(){
        List<String> list = client.getServices();
        System.out.println(list);
        List<ServiceInstance> serviceInstances = client.getInstances("EUREKA-PROVIDER");
        for (ServiceInstance serviceInstance: serviceInstances){
            System.out.println(serviceInstance);
        }
        return client;
    }

    @PostMapping("/sayHello")
    public String sayHello(String name) {
        return "我是服务端" + serverPort + "，你好" + name;
    }

    @PostMapping("/getZuulHeader")
    public String getZuulHeader(HttpServletRequest httpServletRequest) {
        return "我是服务端" + serverPort + ",zuul的Cookie请求头为" + httpServletRequest.getHeader("Cookie");
    }
}
