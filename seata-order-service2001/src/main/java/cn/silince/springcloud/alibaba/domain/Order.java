package cn.silince.springcloud.alibaba.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @program: cloud2020
 * @description:
 * @author: Silince
 * @create: 2020-11-30 14:27
 **/
@Data
@AllArgsConstructor
public class Order {
    private Long id;
    private Long userId;
    private Long productId;
    private Integer count;
    private BigDecimal money;
    private Integer status; // 订单状态：0 创建中； 1 已完结
}
