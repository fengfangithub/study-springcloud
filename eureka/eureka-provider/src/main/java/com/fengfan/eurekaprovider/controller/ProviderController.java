package com.fengfan.eurekaprovider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author fengfan
 * @description 服务提供者
 * @date 2022/5/18 11:30
 */
@RestController
@RequestMapping("/api")
public class ProviderController {

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/sayHello")
    public String sayHello(String name) {
        return "我是服务端" + serverPort + "，你好" + name;
    }

    @PostMapping("/getZuulHeader")
    public String getZuulHeader(HttpServletRequest httpServletRequest) {
        return "我是服务端" + serverPort + ",zuul的Cookie请求头为" + httpServletRequest.getHeader("Cookie");
    }
}
