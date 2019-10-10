package com.isea.learn.service.impl;

import com.isea.learn.dao.DeptDao;
import com.isea.learn.entities.Dept;
import com.isea.learn.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author isea_you
 * @date 2019/10/10
 * @time 10:44
 * @target:
 */
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptDao dao ;

    @Override
    public boolean add(Dept dept)
    {
        return dao.addDept(dept);
    }

    @Override
    public Dept get(Long id)
    {
        return dao.findById(id);
    }

    @Override
    public List<Dept> list()
    {
        return dao.findAll();
    }

}
