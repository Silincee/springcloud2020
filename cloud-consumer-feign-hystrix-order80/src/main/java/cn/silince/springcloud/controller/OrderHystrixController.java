package cn.silince.springcloud.controller;


import cn.silince.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: cloud2020
 * @description:
 * @author: Silince
 * @create: 2020-11-23 21:02
 **/
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class OrderHystrixController {

    @Autowired
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        return paymentHystrixService.paymentInfo_OK(id);
    }
/*******服务降级*********/

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
//    @HystrixCommand // 使用defaultFallback = "payment_Global_FallbackMethod"
    @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "1500") // 该线程超时时间为1.5s,表示只等服务提供者1.5s
    })
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id){
//        int a = 10/0;
        return paymentHystrixService.paymentInfo_TimeOut(id);
    }

    public String paymentTimeOutFallbackMethod() {
        return "😈Here is paymentTimeOutFallbackMethod, 我是消费者80，对方支付系统繁忙，请10秒钟后再试或者自己运行出错请检查自己";
    }

    public String payment_Global_FallbackMethod(){
        return "😈here is defaultFallback = payment_Global_FallbackMethod";
    }



}
