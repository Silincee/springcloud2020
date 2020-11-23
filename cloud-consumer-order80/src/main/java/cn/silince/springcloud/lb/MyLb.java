package cn.silince.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: cloud2020
 * @description: 自定义负载均衡算法实现类
 * @author: Silince
 * @create: 2020-11-23 13:16
 **/
@Component // 使得容器能扫描得到该类
public class MyLb implements LoadBalancer {

    private AtomicInteger atomicInteger = new AtomicInteger(0); // 原子整型类

    public final int getAndIncrement() {
        int current;
        int next;

        do {
            current = this.atomicInteger.get();
            next = current >= Integer.MAX_VALUE ? 0 : current + 1;
        } while (!this.atomicInteger.compareAndSet(current,next)); // CAS自旋
        System.out.println("****第几次访问，次数next: "+next);
        return next;
    }


    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int index =  getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
