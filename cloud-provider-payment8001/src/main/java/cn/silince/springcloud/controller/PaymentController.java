package cn.silince.springcloud.controller;


import cn.silince.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import cn.silince.springcloud.entities.CommonResult;
import cn.silince.springcloud.entities.Payment;

import java.util.List;
import java.util.concurrent.TimeUnit;

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

    @Value("${server.port}") // 注入yml配置文件中的server.port
    private String serverPort;

    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("****插入结果"+result);

        if (result>0) {
            return new CommonResult(200,"插入数据库成功,serverPort: "+serverPort,result);
        }else {
            return new CommonResult(444,"插入数据库失败",null);
        }

    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id")Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("****插入结果"+payment);

        if (payment!=null) {
            return new CommonResult(200,"查询成功serverPort: "+serverPort,payment);
        }else {
            return new CommonResult(444,"没有对应记录,查询ID："+id,null);
        }
    }

    /**
    * @description: 对于注册进eureka里面的微服务，可以通过服务发现来获得该服务的信息
    */
    @GetMapping(value = "/payment/discovery")
    public Object discovery(){
        // 方式一：获得eureka下所有的微服务名称列表
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("*****element: "+service);
        }

        // 方式二：根据微服务名称获得服务包含的实例列表
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }

        return this.discoveryClient;
    }

    /**
    * @description: 自定义负载均衡算法
    */
    @GetMapping(value = "/payment/lb")
    public String getPaymentLB(){
        return serverPort;
    }

    /**
    * @description: 服务提供方8001故意写暂停程序
    */
    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout(){
        try {
            TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
        return serverPort;
    }
    
    /** 
    * @description: zipkin链路调用测试
    */
    @GetMapping("/payment/zipkin")
    public String paymentZipkin(){
        return "Here is payment zipkin server fall back😈";
    }
}
