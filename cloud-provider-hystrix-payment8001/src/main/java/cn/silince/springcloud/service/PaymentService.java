package cn.silince.springcloud.service;

import cn.silince.springcloud.service.impl.PaymentServiceImpl;

/**
 * @program: cloud2020
 * @description:
 * @author: Silince
 * @create: 2020-11-23 20:14
 **/
public interface PaymentService  {

    public String paymentInfo_OK(Integer id);

    public String paymentInfo_TimeOut(Integer id);


}
