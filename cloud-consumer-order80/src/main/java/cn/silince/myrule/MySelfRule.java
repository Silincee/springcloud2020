package cn.silince.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;

/**
 * @program: cloud2020
 * @description:
 * @author: Silince
 * @create: 2020-11-23 10:38
 **/
public class MySelfRule {

    @Bean
    public IRule myRule(){
        return new RandomRule(); // 定义为随机
    }
}
