package cn.silince.springcloud.alibaba.service;

import cn.silince.springcloud.alibaba.domain.Order;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;


public interface OrderService {

    /**
     * @description: 新建订单
     */
    void create(Order order);


}
