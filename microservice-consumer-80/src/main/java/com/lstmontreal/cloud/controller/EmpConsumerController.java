package com.lstmontreal.cloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.lstmontreal.cloud.entity.Emp;

@RestController
public class EmpConsumerController {

	@Autowired
	private RestTemplate restTemplate;

//	private static final String url="http://localhost:8001";
	private static final String url="http://MICROSERVICE-EMP";
	
	@RequestMapping(value = "/consumer/emp/add")
	public boolean addwo(Emp emp)
	{
		return restTemplate.postForObject(url + "/emp/add", emp, Boolean.class);
	}
	
	
	@GetMapping("/consumer/emp/{id}")
	public ResponseEntity<Emp> getWorkOrder(@PathVariable Long id) {
		return restTemplate.getForEntity(url+"/emp/"+id, Emp.class);
	}
	
	@GetMapping("/consumer/emp")
	public ResponseEntity<List> getAllWorkOrder(){
		ResponseEntity<List> entity = restTemplate.getForEntity(url+"/emp", List.class);
		entity.getBody().stream().forEach(System.out::println);
		return entity;
	}
}
