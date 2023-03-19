package com.fengfan.consumerribbon.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author fengfan
 * @description Ribbo负载均衡使用
 * @date 2022/5/20 15:31
 */
@RestController
@RequestMapping("/api")
public class ConsumerRibbonController {
    @Resource
    private RestTemplate restTemplate;

    @PostMapping("/getServerInfo")
    public String getServerInfo() {
        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("name", "consumer8091");
        ResponseEntity<String> responseEntity = restTemplate.postForEntity("http://EUREKA-PROVIDER/api" +
                "/sayHello", body, String.class);
        return responseEntity.getBody();
    }
}
