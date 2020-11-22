package cn.silince.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @program: cloud2020
 * @description: cloud-provider-payment8001 微服务提供者支付Module模块
 * @author: Silince
 * @create: 2020-11-19 22:51
 **/
@SpringBootApplication
@EnableEurekaClient // EurekaClient通过注册中心进行访问
public class PaymentMain8002 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8002.class, args);
    }
}
