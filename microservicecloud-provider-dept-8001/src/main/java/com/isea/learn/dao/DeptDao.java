package com.isea.learn.dao;

import com.isea.learn.entities.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author isea_you
 * @date 2019/10/10
 * @time 10:20
 * @target:
 */

@Mapper // 这个注解一定要加，是Mybatis的注解
public interface DeptDao {
    public boolean addDept(Dept dept);

    public Dept findById(Long id);

    public List<Dept> findAll();
}
