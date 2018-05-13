package com.lstmontreal.cloud.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.lstmontreal.cloud.entity.Emp;

@Service
@FeignClient(value = "MICROSERVICE-EMP",fallbackFactory=EmpClientServiceFallbackFactory.class)
public interface EmpClientService {

	@PostMapping(value="/emp/add")
	public boolean add(Emp emp);
	
	//方法的@PathVariable("id")的参数一定不能为空。
	@GetMapping(value="/emp/{id}")
	public Emp get(@PathVariable("id") Long id);
	
	@GetMapping(value="/emp")
	public List<Emp> list();
}
