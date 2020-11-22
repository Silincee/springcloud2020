package cn.silince.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @program: cloud2020
 * @description: cloud-provider-payment8001 微服务提供者支付Module模块
 * @author: Silince
 * @create: 2020-11-19 22:51
 **/
@SpringBootApplication
@EnableEurekaClient // EurekaClient通过注册中心进行访问
@EnableDiscoveryClient // 对于注册进eureka里面的微服务，可以通过服务发现来获得该服务的信息
public class PaymentMain8002 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8002.class, args);
    }
}
