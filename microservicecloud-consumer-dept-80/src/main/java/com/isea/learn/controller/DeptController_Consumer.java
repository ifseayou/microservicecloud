package com.isea.learn.controller;
import com.isea.learn.entities.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptController_Consumer
{
//    private static final String REST_URL_PREFIX = "http://localhost:8001";
//    此时从IP地址的方式更改为标准的微服务访问模式
    private static final String REST_URL_PREFIX = "http://MICROSERVICECLOUD-DEPT";


    /**
     * (url,requestMap,ResponseBean.class)
     * 第一个参数REST请求的地址
     * 第二个参数请求参数
     * 第三个参数HTTP响应被返回的类型
     */
    @Autowired
    private RestTemplate restTemplate;

    /**
     * 添加请求：localhost/consumer/dept/add?dname=bigData2019
     * @param dept
     * @return true
     */
    @RequestMapping(value="/consumer/dept/add")
    public boolean add(Dept dept)
    {
        return restTemplate.postForObject(REST_URL_PREFIX+"/dept/add", dept, Boolean.class);
    }

    /**
     * 查询请求：localhost/consumer/dept/get/2
     * @param id
     * @return 返回dept对象
     */
    @RequestMapping(value="/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id)
    {
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get/"+id, Dept.class);
    }

    /**
     * 查询请求：localhost/consumer/list
     * @return 返回一个list
     */
    @SuppressWarnings("unchecked")
    @RequestMapping(value="/consumer/dept/list")
    public List<Dept> list()
    {
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/list", List.class);
    }
}