package cn.silince.springcloud.service.impl;

import cn.silince.springcloud.service.IMessageProvider;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import java.util.UUID;

/**
 * @program: cloud2020
 * @description:
 * @author: Silince
 * @create: 2020-11-27 14:30
 **/
@EnableBinding(Source.class) // 定义消息的推送管道；Source-源
public class MessageProviderImpl implements IMessageProvider {

    @Autowired
    private MessageChannel output;

    /** 
    * @description: 往消息中间件发送流水号 
    */ 
    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("***serial: "+serial);
        return null;
    }
}
