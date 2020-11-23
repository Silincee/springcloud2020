package cn.silince.springcloud.service.impl;

import cn.silince.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

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
        return "线程池: "+ Thread.currentThread().getName()+"  paymentInfo_TimeOutHandler: "+id+"\t" + "😈Here is TimeOutHandler";
    }
}
