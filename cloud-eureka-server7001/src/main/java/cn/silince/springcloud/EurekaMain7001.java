package cn.silince.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @program: cloud2020
 * @description:
 * @author: Silince
 * @create: 2020-11-21 22:29
 **/
@SpringBootApplication
@EnableEurekaServer // 表示当前是 Eureka的服务注册中心
public class EurekaMain7001 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaMain7001.class, args);
    }
}
