package com.isea.learn.service;

import com.isea.learn.entities.Dept;

import java.util.List;

/**
 * @author isea_you
 * @date 2019/10/10
 * @time 10:43
 * @target:
 */
public interface DeptService {
    public boolean add(Dept dept);
    public Dept    get(Long id);
    public List<Dept> list();
}
