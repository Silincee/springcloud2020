package cn.silince.springcloud.service;

import cn.silince.springcloud.service.impl.PaymentServiceImpl;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @program: cloud2020
 * @description:
 * @author: Silince
 * @create: 2020-11-23 20:14
 **/
public interface PaymentService  {

    public String paymentInfo_OK(Integer id);

    public String paymentInfo_TimeOut(Integer id);

    public String paymentCircuitBreaker(Integer id);


}
