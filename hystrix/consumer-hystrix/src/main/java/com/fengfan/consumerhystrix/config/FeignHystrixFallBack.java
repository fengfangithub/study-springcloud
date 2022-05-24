package com.fengfan.consumerhystrix.config;

import com.fengfan.consumerhystrix.api.ProviderService;
import org.springframework.stereotype.Component;

/**
 * @author fengfan
 * @description TODO
 * @date 2022/5/24 16:00
 */
@Component
public class FeignHystrixFallBack implements ProviderService {

    @Override
    public String sayHello(String name) {
        return "远程调用服务端失败";
    }
}
