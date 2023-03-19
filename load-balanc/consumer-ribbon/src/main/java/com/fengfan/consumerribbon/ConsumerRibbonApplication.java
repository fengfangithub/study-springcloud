package com.fengfan.consumerribbon;

import com.fengfan.rule.MyRuleConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
/**
 * 在启动改微服务的时候就能去加载我们自定义的Ribbon配置类，从而配置生效
 * 注意：MyRuleConfig 必须是 @Configuration ，但请注意，它不在主应用程序上下文
 * 的 @ComponentScan 中，否则将由所有 @RibbonClients 共享。
 * 如果您使用 @ComponentScan （或 @SpringBootApplication ），
 * 则需要采取措施避免包含（例如将其放在一个单独的，不重叠的包中，或者指定要在 @ComponentScan ）
 */
@RibbonClient(name = "EUREKA-PROVIDER", configuration = MyRuleConfig.class)
public class ConsumerRibbonApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerRibbonApplication.class, args);
    }

}
