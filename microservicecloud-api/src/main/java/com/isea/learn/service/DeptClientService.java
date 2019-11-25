package com.isea.learn.service;

import com.isea.learn.entities.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author isea_you
 * @date 2019/10/10
 * @time 16:06
 * @target:  一个接口+一个注解：该接口作用在 MICROSERVICECLOUD-DEPT 微服务上
 */
//@FeignClient(value = "MICROSERVICECLOUD-DEPT") // 该接口下的所有方法有异常都找fallbackFactory
@FeignClient(value = "MICROSERVICECLOUD-DEPT" ,fallbackFactory = DeptClientServiceFallbackFactory.class)
public interface DeptClientService
{
    @RequestMapping(value = "/dept/get/{id}",method = RequestMethod.GET)
    public Dept get(@PathVariable("id") long id);

    @RequestMapping(value = "/dept/list",method = RequestMethod.GET)
    public List<Dept> list();

    @RequestMapping(value = "/dept/add",method = RequestMethod.POST)
    public boolean add(Dept dept);
}

