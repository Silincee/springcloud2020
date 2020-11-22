package cn.silince.springcloud.dao;

import cn.silince.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @program: cloud2020
 * @description:
 * @author: Silince
 * @create: 2020-11-20 20:10
 **/
@Mapper
public interface PaymentDao {
    /**
    * @description: 写操作
    */
    public int create(Payment payment);

    /**
    * @description: 读操作
    */
    public Payment getPaymentById(@Param("id") Long id);
}
