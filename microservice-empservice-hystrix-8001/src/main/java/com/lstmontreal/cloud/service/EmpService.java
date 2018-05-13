package com.lstmontreal.cloud.service;

import java.util.List;

import com.lstmontreal.cloud.entity.Emp;

public interface EmpService {
	public boolean add(Emp emp);
	public Emp get(Long id);
	public List<Emp> list();
}
