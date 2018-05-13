package com.lstmontreal.cloud.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lstmontreal.cloud.entity.Emp;

@Mapper
public interface EmpDao {
	public boolean addEmp(Emp emp);
	public Emp findById(Long id);
	public List<Emp> findAll();
}
