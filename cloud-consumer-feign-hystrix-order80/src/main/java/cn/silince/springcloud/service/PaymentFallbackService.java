package cn.silince.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @program: cloud2020
 * @description:
 * @author: Silince
 * @create: 2020-11-23 22:50
 **/
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "-----PaymentFallbackService fall back-paymentInfo_OK,😈";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "-----PaymentFallbackService fall back-paymentInfo_TimeOut,😈";
    }
}
