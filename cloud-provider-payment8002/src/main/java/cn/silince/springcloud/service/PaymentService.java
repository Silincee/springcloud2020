package cn.silince.springcloud.service;

import cn.silince.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {
    /**
     * @description: 写操作
     */
    public int create(Payment payment);

    /**
     * @description: 读操作
     */
    public Payment getPaymentById(@Param("id") Long id);
}
