package cn.silince.springcloud.alibaba.myhandler;

import cn.silince.springcloud.entities.CommonResult;
import cn.silince.springcloud.entities.Payment;
import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * @program: cloud2020
 * @description: 自定义
 * @author: Silince
 * @create: 2020-11-29 20:31
 **/

public class CustomerBlockHandler {

    public static CommonResult handlerException(BlockException exception){
        return new CommonResult(4444,"按客户自定义，global handlerException---1");
    }

    public static CommonResult handlerException2(BlockException exception){
        return new CommonResult(4444,"按客户自定义，global handlerException---2");
    }
}
