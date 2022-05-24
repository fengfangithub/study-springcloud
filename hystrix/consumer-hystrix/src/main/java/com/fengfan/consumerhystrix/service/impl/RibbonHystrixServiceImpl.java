package com.fengfan.consumerhystrix.service.impl;

import com.fengfan.consumerhystrix.service.RibbonHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author fengfan
 * @description ribbon使用hystrix接口层
 * @date 2022/5/24 15:26
 */
@Service
public class RibbonHystrixServiceImpl implements RibbonHystrixService {
    @Resource
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "error")
    @Override
    public String getServerInfo() {
        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("name", "consumer-Hystrix");
        ResponseEntity<String> responseEntity = restTemplate.postForEntity("http://EUREKA-PROVIDER/provider/api/sayHello", body, String.class);
        return responseEntity.getBody();
    }

    public String error() {
        return "远程调用服务端失败";
    }

}
