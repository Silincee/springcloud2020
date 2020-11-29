package cn.silince.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @program: cloud2020
 * @description:
 * @author: Silince
 * @create: 2020-11-29 12:34
 **/
@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA(){
        
        return "------testA";
    }

    @GetMapping("/testB")
    public String testB(){
        return "------testB";
    }

    @GetMapping("/testD")
    public String testD(){
        try {
            TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
        log.info("testD 测试RT");
        return "------testD";
    }

    @GetMapping("/testD2")
    public String testD2(){

        log.info("testD2 异常比例");
        return "------testD2";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler = "deal_testHotKey") // value可为唯一的任意值
    public String testHotKey(@RequestParam(value = "p1",required = false) String p1,
                             @RequestParam(value = "p2",required = false) String p2){
        return "-------testHotKey";
    }

    public String deal_testHotKey(String p1, String p2, BlockException exception){
        return "----deal_testHotKey,😈"; //sentinel系统默认的提示: Blocked by Sentinel （flow limiting）
    }

}
