package cn.silince.springcloud.controller;


import cn.silince.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import cn.silince.springcloud.entities.CommonResult;
import cn.silince.springcloud.entities.Payment;

/**
 * @program: cloud2020
 * @description:
 * @author: Silince
 * @create: 2020-11-20 21:03
 **/
@RestController // @RestController = @ResponseBody ＋ @Controller
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("****插入结果"+result);

        if (result>0) {
            return new CommonResult(200,"插入数据库成功",result);
        }else {
            return new CommonResult(444,"插入数据库失败",null);
        }

    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id")Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("****插入结果"+payment);

        if (payment!=null) {
            return new CommonResult(200,"查询成功",payment);
        }else {
            return new CommonResult(444,"没有对应记录,查询ID："+id,null);
        }
    }
}
