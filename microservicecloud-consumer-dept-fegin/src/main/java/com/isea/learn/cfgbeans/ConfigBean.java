package com.isea.learn.cfgbeans;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author isea_you
 * @date 2019/10/10
 * @time 11:51
 * @target:
 */
@Configuration
public class ConfigBean
{
    @Bean
    @LoadBalanced // Ribbon实现客户端的负载均衡
    public RestTemplate getRestTemplate()
    {
        return new RestTemplate();
    }
}