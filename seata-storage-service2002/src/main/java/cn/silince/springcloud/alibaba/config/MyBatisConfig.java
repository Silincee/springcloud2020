package cn.silince.springcloud.alibaba.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@MapperScan({"cn.silince.springcloud.alibaba.dao"})
public class MyBatisConfig {
}
