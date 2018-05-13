package com.lstmontreal.cloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.lstmontreal.cloud.entity.Emp;
import com.lstmontreal.cloud.service.EmpClientService;

@RestController
public class EmpConsumerController {
	
	@Autowired
	private EmpClientService service;
	
	@GetMapping("/consumer/emp/add")
	public boolean add(Emp emp){
		return service.add(emp);
	}
	
	@GetMapping("/consumer/emp/{id}")
	public Emp getWorkOrder(@PathVariable Long id) {
		return service.get(id);
	}
	
	@GetMapping("/consumer/emp")
	public List<Emp> getAllEmp(){
		return service.list();
	}
	
}
