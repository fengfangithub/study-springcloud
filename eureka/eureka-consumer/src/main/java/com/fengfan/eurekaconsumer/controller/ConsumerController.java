package com.fengfan.eurekaconsumer.controller;

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
 * @description 消费者controller
 * @date 2022/5/18 14:35
 */
@RestController
@RequestMapping("/api")
public class ConsumerController {
    @Resource
    private RestTemplate restTemplate;

    @PostMapping("/askHello")
    public String askHello(){
        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("name", "consumer8090");
        ResponseEntity<String> responseEntity = restTemplate.postForEntity("http://EUREKA-PROVIDER/api/sayHello", body, String.class);
        return responseEntity.getBody();
    }
}
