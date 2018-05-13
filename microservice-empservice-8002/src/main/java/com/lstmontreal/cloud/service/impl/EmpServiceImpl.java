package com.lstmontreal.cloud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lstmontreal.cloud.dao.EmpDao;
import com.lstmontreal.cloud.entity.Emp;
import com.lstmontreal.cloud.service.EmpService;

@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	private EmpDao dao;
	
	@Override
	public boolean add(Emp emp) {
		return dao.addEmp(emp);
	}

	@Override
	public Emp get(Long id) {
		return dao.findById(id);
	}

	@Override
	public List<Emp> list() {
		return dao.findAll();
	}

}
