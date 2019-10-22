package com.isea.learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author isea_you
 * @date 2019/10/10
 * @time 11:51
 * @target:
 */
@EnableEurekaClient   //本服务启动后会自动注册进eureka服务中
@SpringBootApplication
@EnableFeignClients(basePackages = {"com.isea.learn", "com.joinbright.iot"})
@ComponentScan(basePackages = {"com.isea.learn", "com.joinbright.iot"})
public class DeptConsumerFegin_App {

//    @Autowired
//    static   RealTimeClientService realTimeClientService = null;

    public static void main(String[] args) {
        SpringApplication.run(DeptConsumerFegin_App.class, args);
    }
}
