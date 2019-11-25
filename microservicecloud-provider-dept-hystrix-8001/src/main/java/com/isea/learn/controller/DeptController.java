package com.isea.learn.controller;

import com.isea.learn.entities.Dept;
import com.isea.learn.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author isea_you
 * @date 2019/10/10
 * @time 10:49
 * @target:
 */
@RestController
public class DeptController {
    @Autowired
    private DeptService service;

    @RequestMapping(value="/dept/get/{id}",method=RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "processHystrix_Get") // 1，这里业务逻辑和异常处理直接耦合在一起，2，没有业务方法都有对应的一个异常处理方法，应该是用AOP的思想来进行改进
    // fallbackMethod = "processHystrix_Get"，如果调用服务方法失败并抛出异常信息之后，会自动调用@HystrixCommand标注好的fallbackMethod调用类中的指定方法
    public Dept get(@PathVariable("id") Long id)
    {
        Dept dept =  this.service.get(id);
        if(null == dept)
        {
            throw new RuntimeException("该ID："+id+"没有没有对应的信息");
        }
        return dept;
    }

    public Dept processHystrix_Get(@PathVariable("id") Long id)
    {
        return new Dept().setDeptno(id)
                .setDname("该ID："+id+"没有没有对应的信息,null--@HystrixCommand")
                .setDb_source("no this database in MySQL");
    }
}
