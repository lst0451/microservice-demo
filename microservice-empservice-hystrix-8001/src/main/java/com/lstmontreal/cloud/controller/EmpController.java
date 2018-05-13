package com.lstmontreal.cloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lstmontreal.cloud.entity.Emp;
import com.lstmontreal.cloud.service.EmpService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class EmpController {
	
	@Autowired
	private EmpService service;
	@Autowired
	private DiscoveryClient client;

	@PostMapping(value="/emp/add")
	public boolean addWorkOrder(@RequestBody Emp emp) {
		return service.add(emp);
	}
	
	@GetMapping(value="/emp/{id}")
	@HystrixCommand(fallbackMethod = "hystrixGet")
	public Emp getEmp(@PathVariable Long id) {
		return service.get(id);
	}
	
	@GetMapping(value="/emp")
	public List<Emp> getAll() {
		return service.list();
	}
	
	@GetMapping(value = "/services")
	public Object discovery()
	{
		List<String> list = client.getServices();
		System.out.println("**********" + list);

		List<ServiceInstance> srvList = client.getInstances("MICROSERVICE-EMP");
		for (ServiceInstance element : srvList) {
			System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
					+ element.getUri());
		}
		return this.client;
	}
	
	public Emp hystrixGet(@PathVariable Long id) {
		return new Emp().setEmpno(id).setLastName("调用出现异常，无法提供ID为：["+id+"]的员工信息");
	}
	
}
