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
 *  在spring boot中简化了spring的applicationContext.xml的配置文件，也就是说：
 * 类名ConfigBenz + @Configuration注解 就等价于 applicationContext.xml配置文件
 * 在spring中的配置
 *  <bean id = "userService" class = "com.isea.virgin.UserServiceImpl></bean>
 * 也就等价于在boot中的如下类
 * @Bean
 * public UserService getUserService(){
 *     return new UserServiceImpl();
 * }
 */
@Configuration
public class ConfigBean
{
    /**
     * spring   调用JDBC，         使用 JDBCTemplate
     * spring   调用redis          使用 redisTemplate
     * spring   发起rest请求       使用RestTemplate
     *  RestTemplate提供了多种便捷访问远程HTTP服务的方法，是Spring提供的用于访问REST服务的客户端模板工具集
     * @return
     */
    @Bean
    @LoadBalanced // 80作为消费者，使用Ribbon来实现客户端的负载均衡，或者说是消费者端的负载均衡
    public RestTemplate getRestTemplate()
    {
        return new RestTemplate();
    }
}

