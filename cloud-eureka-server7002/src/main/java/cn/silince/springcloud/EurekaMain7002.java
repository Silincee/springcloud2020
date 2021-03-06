package cn.silince.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @program: cloud2020
 * @description:
 * @author: Silince
 * @create: 2020-11-22 14:07
 **/
@SpringBootApplication
@EnableEurekaServer // Eureka Server提供服务注册服务
public class EurekaMain7002 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaMain7002.class, args);
    }
}
