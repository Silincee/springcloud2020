package cn.silince.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @program: cloud2020
 * @description: cloud-provider-payment8001 微服务提供者支付Module模块
 * @author: Silince
 * @create: 2020-11-19 22:51
 **/
@SpringBootApplication
public class PaymentMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8001.class, args);
    }
}
