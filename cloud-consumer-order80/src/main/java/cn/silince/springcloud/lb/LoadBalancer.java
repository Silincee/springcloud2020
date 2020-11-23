package cn.silince.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
* @description: 自定义负载均衡算法接口
*/
public interface LoadBalancer {

    /**
    * @description: 获取所有服务实例列表
    */
    ServiceInstance instances(List<ServiceInstance> serviceInstances);

}
