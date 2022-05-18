package com.fengfan.eurekaprovider.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fengfan
 * @description 服务提供者
 * @date 2022/5/18 11:30
 */
@RestController("/provider")
public class PoroviderController {

    @PostMapping("/sayHello")
    public void sayHello(String name){
        System.out.println("hello：" + name);
    }
}
