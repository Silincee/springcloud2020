package cn.silince.springcloud.service.impl;

import cn.silince.springcloud.service.PaymentService;
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

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        int timeNumber = 3;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);} catch (InterruptedException e) {e.printStackTrace();}
        return "线程池: "+ Thread.currentThread().getName()+"  paymentInfo_TimeOut: "+id+"\t" + "😭耗时(s): "+timeNumber;
    }
}
