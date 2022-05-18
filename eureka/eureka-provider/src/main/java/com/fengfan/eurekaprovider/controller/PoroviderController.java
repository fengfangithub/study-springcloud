package com.fengfan.eurekaprovider.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fengfan
 * @description 服务提供者
 * @date 2022/5/18 11:30
 */
@RestController
@RequestMapping("/api")
public class PoroviderController {

    @PostMapping("/sayHello")
    public String sayHello(String name){
        return "hello：" + name;
    }
}
