package com.isea.learn.controller;

import com.isea.learn.entities.Dept;
import com.isea.learn.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

/**
 * @author isea_you
 * @date 2019/10/10
 * @time 11:53
 * @target:
 */

@RestController
public class DeptController_Feign
{
    @Autowired
    private DeptClientService service = null;

    @RequestMapping(value = "/consumer1/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id)
    {
        return this.service.get(id);
    }

    @RequestMapping(value = "/consumer1/dept/list")
    public List<Dept> list()
    {
        return this.service.list();
    }

    @RequestMapping(value = "/consumer1/dept/add")
    public Object add(Dept dept)
    {
        return this.service.add(dept);
    }
}

