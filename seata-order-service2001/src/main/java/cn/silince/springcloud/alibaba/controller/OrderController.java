package cn.silince.springcloud.alibaba.controller;

import cn.silince.springcloud.alibaba.domain.CommonResult;
import cn.silince.springcloud.alibaba.domain.Order;
import cn.silince.springcloud.alibaba.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: cloud2020
 * @description:
 * @author: Silince
 * @create: 2020-11-30 15:36
 **/
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/order/create") // 为什么写Get不应该是POST，因为这是暴露给浏览器用的。真正的写操作在@FeignClient(value = "seata-account-service")的POSTMAPPING
    public CommonResult create(Order order){
        orderService.create(order);
        return new CommonResult(200,"订单创建成功");
    }
}
