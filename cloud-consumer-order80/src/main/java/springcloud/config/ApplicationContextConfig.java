package springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
* @description:  RestTemplate 配置类
*/
@Configuration
public class ApplicationContextConfig
{
    @Bean // 相当于在applicationContext.xml中配置了 <bean id="" class="">
    public RestTemplate getRestTemplate()
    {
        return new RestTemplate();
    }
}
