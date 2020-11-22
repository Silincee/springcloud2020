package cn.silince.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @program: cloud2020
 * @description: cloud-consumer-order80 微服务消费者订单Module模块
 * @author: Silince
 * @create: 2020-11-19 22:51
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class OrderMainZK80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMainZK80.class, args);
    }
}
