package cn.silince.springcloud.controller;

import cn.silince.springcloud.entities.CommonResult;
import cn.silince.springcloud.entities.Payment;
import cn.silince.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: cloud2020
 * @description:
 * @author: Silince
 * @create: 2020-11-23 18:54
 **/
@RestController
@Slf4j
public class OrderFeignController {

    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id")Long id) {
        return paymentFeignService.getPaymentById(id);
    }
}
