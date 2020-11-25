package cn.silince.springcloud.service.impl;


import cn.hutool.core.util.IdUtil;
import cn.silince.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @program: cloud2020
 * @description:
 * @author: Silince
 * @create: 2020-11-23 20:15
 **/
@Service
public class PaymentServiceImpl implements PaymentService {

    /**
     * @description: 正常访问，肯定ok
     */
    @Override
    public String paymentInfo_OK(Integer id) {
        return "线程池: "+ Thread.currentThread().getName()+"  paymentInfo_OK: "+id+"\t" + "😄";
    }

    // 设置自身调用超时时间的峰值，峰值内可以正常运行，超过了需要有兜底的方法处理，作服务降级fallback
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "3000") // 该线程超时时间为3s
    })
    @Override
    public String paymentInfo_TimeOut(Integer id) {
        int timeNumber = 5; // 5>3
//        int age = 10/0;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);} catch (InterruptedException e) {e.printStackTrace();}
        return "线程池: "+ Thread.currentThread().getName()+"  paymentInfo_TimeOut: "+id+"\t" + "😭耗时(s): "+timeNumber;
    }

    public String paymentInfo_TimeOutHandler(Integer id) {
        return "线程池: "+ Thread.currentThread().getName()+"  系统繁忙,请稍后再试: "+id+"\t" + "😈Here is TimeOutHandler";
    }

    /*******服务熔断*********/

    @HystrixCommand(fallbackMethod = "paymentCircuitBreak_fallback",commandProperties = {
            @HystrixProperty(name="circuitBreaker.enabled",value = "true"), // 是否开启断路器
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value = "10"),// 请求次数
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value = "10000"), // 时间窗口期
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value = "60"), // 失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(Integer id){
        if (id<0){
            throw new RuntimeException("****id 不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName()+"\t" +"调用成功，流水号：" +serialNumber;
    }

    public String paymentCircuitBreak_fallback(Integer id){
        return "id 不能为负数，请稍后再试。 当前id: "+id;
    }
}
