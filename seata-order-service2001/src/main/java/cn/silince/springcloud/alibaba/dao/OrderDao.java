package cn.silince.springcloud.alibaba.dao;

import cn.silince.springcloud.alibaba.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderDao {

    /**
    * @description: 新建订单
    */
    void create(Order order);

    /**
    * @description: 修改订单状态，从0改为1
    */
    void update(@Param("userId") Long userId,@Param("status") Integer status);

}
